package cn.gmluo.searchapitest.searchservice.controller;


import cn.gmluo.searchapitest.getresponse.GetSearchApiResponse;
import cn.gmluo.searchapitest.getresponse.requesttype.intervention.ExecuteIdList;
import cn.gmluo.searchapitest.getresponse.requesttype.intervention.GetMarchResultType;
import cn.gmluo.searchapitest.getresponse.responsetype.intervention.CheckAllRepsonseType;
import cn.gmluo.searchapitest.getresponse.responsetype.intervention.CheckListParameter;
import cn.gmluo.searchapitest.requestsource.searchapisource.activity.dailytravel.DailyTravelInterventionSource;
import cn.gmluo.searchapitest.requestsource.searchapisource.activity.district.ActivityInterventionSource;
import cn.gmluo.searchapitest.requestsource.searchapisource.scenicspot.district.ScenicInterventionSource;
import cn.gmluo.searchapitest.searchservice.entity.Intervention;
import cn.gmluo.searchapitest.searchservice.service.InterventionService;
import cn.gmluo.searchapitest.searchservice.util.PageBean;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 4.控制层
 * 4.1Controller控制类实现
 * Created by gmluo on 2018/5/10.
 */
@Controller
@RequestMapping("/intervention")
public class InterventionController {
    @Resource(name = "interventionServiceImpl")
    private InterventionService interventionService;


    @ResponseBody
    @RequestMapping(value = "findMarchResult",method = RequestMethod.POST)
    public PageBean<Intervention> findMarchResult(@RequestBody GetMarchResultType resultType){
        PageBean<Intervention> pageBean=new PageBean<>();
        interventionService.filterFindMatchResult(pageBean,resultType);
        return pageBean;
    }

    /**
     * 全量检查人工干预排序操作
     * 请求参数"apiTypeList": [1,2,3]
     * @param executeIdList
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @ResponseBody
    @RequestMapping(value = "executeInterventionCheck", method = RequestMethod.POST)
    public CheckAllRepsonseType executeInterventionCheck(@RequestBody ExecuteIdList executeIdList) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        List<Integer> apiTypeListlist=executeIdList.getApiTypeList();
        return getCheckAllRepsonseType(apiTypeListlist);
    }



    /**
     * 根据apiType执行批量操作
     * @param apiType
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws IOException
     */
    public CheckListParameter interventiontest(int apiType) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String checkList;//验证的列表页名称
        int districtCount=0;//验证的目的地数量
        int productCount=0;//验证的总产品数
        int successCount=0;//验证正确排序产品数
        int failCount=0;//验证排序失败产品数
        int narCount=0;//接口无返回的产品数（NoApiReturn）
        int tgCount=0;//本身为推广产品数


        checkList=getLsitName(apiType);//获得验证的列表页名称

        //根据apiType获取对应列表页中人工配置信息（jsonObject）
        // apiType(1:门票列表页;2:混排列表页;3:一日游列表页)
        JSONObject jsonObject = new GetSearchApiResponse().getInterventionInfo(apiType);

        List<Intervention> errorInterventionList = new ArrayList<Intervention>();
        List<Intervention> successInterventionList = new ArrayList<Intervention>();
        JSONArray resultJSONArray=new JSONArray();

        //获取人工配置信息jsonObject中的所有目的地id的key值（keys）
        Set<String> keys = jsonObject.keySet();
        Iterator iterator = keys.iterator();
        //遍历所有目的地id的key值，获取对应目的地下配置的景点信息，跟相应的门票目的地搜索结果进行对比
        while (iterator.hasNext()) {
            districtCount++;//统计验证的目的地数量
            //获取目的地id的key
            String key = (String) iterator.next();//当前目的地id

            //获取对应目的地id下配置的产品信息interventionJSONArray
            JSONArray interventionJSONArray = jsonObject.getJSONArray(key);

            //根据列表页类型以及目的地的key值获取对应的返回报文jsonArray
//            JSONArray jsonArray = interventionTest.getSearchApiJSONArray(apiType,key);
            JSONArray jsonArray = getSearchApiJSONArray(apiType,key);

            //获取搜索返回报文jsonArray中产品排序信息
            LinkedHashMap<String, String> idMap = getApiIdMap(jsonArray);

            //获取当前目的地下的推广数
            int tuiguangCount = getTuiguangCount(idMap);
            int variableCount = tuiguangCount;//设置一个变量用来动态计算产品实际排序位置

            //遍历当前目的地下人工配置产品信息
            for (int i = 0; i < interventionJSONArray.size(); i++) {
                productCount++;//统计验证的总产品数

                Intervention intervention = new Intervention();

                String productId;               //人工干预的产品id
                int sortOrder;                  //人工干预产品的排序序号
                Boolean isTuiguang;            //该产品是否是推广产品
                Boolean apiReturn;              //搜索接口是否有返回该产品
                int searchApiOrder;             //搜索接口中排序
                Boolean march;                  //搜索接口中该产品是否在正确的位置
                int testStatus;                 //验证状态1：success;2:fail;3:推广产品;4:搜索接口无返回

                JSONObject itemJSONObject = interventionJSONArray.getJSONObject(i);
                //获得具体的产品id
                productId = itemJSONObject.getString("productId").replace("_2", "").replace("_0", "");//对productId进行截取处理将末尾的"_2"或"_0"去除
                //获得该产品人工配置的排序位置
                sortOrder = itemJSONObject.getInteger("sortOrder");

                //判断idMap中是否存在该产品id
                if (idMap.containsKey(productId)) {
                    apiReturn = true;//搜索接口是有返回该产品

                    //获取该产品在搜索api中的位置、是否是推广信息
                    String mapValue = idMap.get(productId);
                    searchApiOrder = Integer.parseInt(mapValue.substring(mapValue.length() - 1, mapValue.length()));//获得该产品在搜索列表中的实际排序

                    //判断该产品是否被设置为推广产品
                    isTuiguang = mapValue.contains("isadtop") ? true : false;
                    //如果该产品为推广,且排序小于列表中推广个数
                    if (isTuiguang && searchApiOrder <= tuiguangCount) {
                        tgCount++;//统计本身为推广产品数
                        march = false;
                        testStatus = 3;
                        variableCount--;
                    } else {
                        march = (sortOrder + variableCount == searchApiOrder) ? true : false;
//                        testStatus = march ? 1 : 2;
                        if (march){
                            testStatus=1;
                            successCount++;//统计验证正确排序产品数
                        }else {
                            testStatus=2;
                            failCount++;//统计验证排序失败产品数
                        }
                    }
                } else {
                    narCount++;//统计接口无返回的产品数（NoApiReturn）

                    apiReturn = false;//搜索接口是没有有返回该产品
                    searchApiOrder = -1;
                    isTuiguang = false;
                    march = false;
                    testStatus = 4;
                    variableCount--;
                }
                intervention = getIntervention(apiType, key, productId, sortOrder, searchApiOrder, isTuiguang, apiReturn, march, testStatus);

                interventionService.insertResult(intervention);
            }

        }
        return getCheckListParameter(checkList,districtCount,productCount,successCount,failCount,narCount,tgCount);
    }

    /**
     * 包装对象CheckAllRepsonseType
     * @param list
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public CheckAllRepsonseType getCheckAllRepsonseType(List<Integer> list) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        List<String> checkLists=new ArrayList<>();//验证的列表页集合
        int totalDistrictCount=0;//验证的目的地总数
        int totalProductCount=0;//验证的总产品数
        int totalSuccessCount=0;//验证正确产品总数
        int totalFailCount=0;//验证失败产品总数数
        int totalNARCount=0;//搜索接口无返回的产品总数（NAR=No Api Return）
        int totalTGCount=0;//本身为推广产品总数数(TG=tuiguang)
        List<CheckListParameter> checkListParameters=new ArrayList<>();//每个列表页验证结果集

        for (int i:list){
            CheckListParameter checkListParameter=interventiontest(i);
            checkLists.add(checkListParameter.getCheckList());
            totalDistrictCount+=checkListParameter.getDistrictCount();
            totalProductCount+=checkListParameter.getProductCount();
            totalSuccessCount+=checkListParameter.getSuccessCount();
            totalFailCount+=checkListParameter.getFailCount();
            totalNARCount+=checkListParameter.getNarCount();
            totalTGCount+=checkListParameter.getTgCount();
            checkListParameters.add(checkListParameter);
        }

        CheckAllRepsonseType checkAllRepsonseType=new CheckAllRepsonseType();
        checkAllRepsonseType.setCheckLists(checkLists);
        checkAllRepsonseType.setTotalDistrictCount(totalDistrictCount);
        checkAllRepsonseType.setTotalProductCount(totalProductCount);
        checkAllRepsonseType.setTotalSuccessCount(totalSuccessCount);
        checkAllRepsonseType.setTotalFailCount(totalFailCount);
        checkAllRepsonseType.setTotalNARCount(totalNARCount);
        checkAllRepsonseType.setTotalTGCount(totalTGCount);
        checkAllRepsonseType.setCheckListParameters(checkListParameters);

        return checkAllRepsonseType;
    }


    /**
     * 根据目的地id、定位id获取玩乐目的地搜索返回报文
     *
     * @param districtID
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public JSONArray getActivityResponse(String districtID) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        ActivityInterventionSource interventionSource = new ActivityInterventionSource();
        interventionSource.setDistrictList_DingweiID("2");
        interventionSource.setDistrictList_DistrictID(districtID);
        JSONArray jsonArray = new GetSearchApiResponse().getActivityJSONArrayResponse(interventionSource.getActivitySearchSource());
        return jsonArray;
    }

    /**
     * 根据目的地id、定位id获取玩乐一日游搜索返回报文
     *
     * @param districtID
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public JSONArray getDailyTravelResponse(String districtID) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        DailyTravelInterventionSource interventionSource = new DailyTravelInterventionSource();
        interventionSource.setDistrictList_DingweiID("2");
        interventionSource.setDistrictList_DistrictID(districtID);
        JSONArray jsonArray = new GetSearchApiResponse().getActivityJSONArrayResponse(interventionSource.getActivitySearchSource());
        return jsonArray;
    }

    /**
     * 根据目的地id获取门票目的地搜索返回报文
     *
     * @param districtID
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public JSONArray getScenicResponse(String districtID) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        ScenicInterventionSource interventionSource = new ScenicInterventionSource();
        interventionSource.setDistrictID(districtID);
        JSONArray jsonArray = new GetSearchApiResponse().getScenicJSONArrayResponse(interventionSource.getScenicSearchSource());
        return jsonArray;
    }

    /**
     *根据列表页类型以及目的地的key值获取对应的返回报文jsonArray
     * @param apiType
     * @param key
     * @return
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws IOException
     */
    public JSONArray getSearchApiJSONArray(int apiType,String key) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        JSONArray jsonArray=new JSONArray();
        switch (apiType) {
            case 1:
                jsonArray = getScenicResponse(key);//获取门票目的地搜索返回报文
                break;
            case 2:
                jsonArray = getActivityResponse(key);//获取玩乐目的地搜索返回报文
                break;
            case 3:
                jsonArray=getDailyTravelResponse(key);//获取一日游搜索返回报文
                break;
            default:
                break;
        }
        return jsonArray;
    }


    /**
     * 根据apiType获得对应列表页的名称
     * @param apiType
     * @return
     */
    public String getLsitName(int apiType){
        String listName=null;
        switch (apiType){
            case 1:
                listName="门票列表页";
                break;
            case 2:
                listName="混排列表页";
                break;
            case 3:
                listName="一日游列表页";
                break;
            default:
                break;
        }
        return listName;
    }


    /**
     * 处理返回报文中的数据,获得产品idList（如果列表中有推广产品，使用isadtop代替其位置）
     *
     * @param jsonArray
     * @return
     */
    public List<String> getIdList(JSONArray jsonArray) {
        List<String> idList = new ArrayList<String>();
        for (Object obj : jsonArray) {
            JSONObject item = (JSONObject) obj;
            String id = item.getString("iD");

            JSONArray fieldList = item.getJSONArray("fieldList");
            int topCount = 0;
            for (Object itemObj : fieldList) {
                JSONObject chileItem = (JSONObject) itemObj;
                String fieldName = chileItem.getString("fieldName");
                if (fieldName.equals("isadtop")) {
                    topCount += 1;
                } else {
                    topCount += 0;
                }
            }
            if (topCount > 0) {
                idList.add("isadtop");
            } else {
                idList.add(id);
            }
        }
        return idList;
    }

    /**
     * 获取搜索接口处理返回报文中的数据,获得产品idList（如果列表中有推广产品，使用isadtop代替其位置）
     *
     * @param jsonArray
     * @return
     */
    public LinkedHashMap getApiIdMap(JSONArray jsonArray) {
        LinkedHashMap<String, String> idMap = new LinkedHashMap<String, String>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject item = (JSONObject) jsonArray.get(i);
            String id = item.getString("iD");
            JSONArray fieldList = item.getJSONArray("fieldList");
            int isTop = 0;
            for (Object itemObj : fieldList) {
                JSONObject childItem = (JSONObject) itemObj;
                String fieldName = childItem.getString("fieldName");
                if (fieldName.equals("isadtop")) {
                    isTop += 1;
                } else {
                    isTop += 0;
                }
            }
            if (isTop >= 1) {
                idMap.put(id, "isadtop_" + (i + 1));
            } else {
                idMap.put(id, "nottop_" + (i + 1));
            }
        }
        return idMap;
    }

    /**
     * 获取列表中的推广产品个数
     *
     * @param map
     * @return
     */
    public int getTuiguangCount(LinkedHashMap<String, String> map) {
        int tuiguangCount = 0;
        for (String key : map.keySet()) {
            if (map.get(key).contains("isadtop")) {
                tuiguangCount += 1;
            } else {
                tuiguangCount += 0;
            }
        }
        return tuiguangCount;
    }


    /**
     * 包装对象Intervention
     *
     * @param searchType
     * @param district
     * @param productId
     * @param sortOrder
     * @param searchApiOrder
     * @param tuiguang
     * @param apiReturn
     * @param march
     * @param testStatus
     * @return
     */
    public Intervention getIntervention(int searchType,
                                        String district,
                                        String productId,
                                        int sortOrder,
                                        int searchApiOrder,
                                        Boolean tuiguang,
                                        Boolean apiReturn,
                                        Boolean march,
                                        int testStatus) {

        Intervention intervention = new Intervention();
        intervention.setSearchType(searchType);
        intervention.setDistrictId(Integer.parseInt(district));
        intervention.setProductId(Long.parseLong(productId));
        intervention.setSortOrder(sortOrder);
        intervention.setSearchApiOrder(searchApiOrder);
        intervention.setTuiguang(tuiguang);
        intervention.setApiReturn(apiReturn);
        intervention.setMarch(march);
        intervention.setTestStatus(testStatus);

        return intervention;
    }

    /**
     *包装对象CheckListParameter
     *
     * @param checkList
     * @param districtCount
     * @param productCount
     * @param successCount
     * @param failCount
     * @param narCount
     * @param tgCount
     * @return
     */
    public CheckListParameter getCheckListParameter(String checkList,
                                                    int districtCount,
                                                    int productCount,
                                                    int successCount,
                                                    int failCount,
                                                    int narCount,
                                                    int tgCount){
        CheckListParameter checkListParameter=new CheckListParameter();
        checkListParameter.setCheckList(checkList);
        checkListParameter.setDistrictCount(districtCount);
        checkListParameter.setProductCount(productCount);
        checkListParameter.setSuccessCount(successCount);
        checkListParameter.setFailCount(failCount);
        checkListParameter.setNarCount(narCount);
        checkListParameter.setTgCount(tgCount);

        return checkListParameter;
    }

}