package cn.gmluo.searchapitest.requestsource.searchapisource.activity.district;

import cn.gmluo.searchapitest.apibase.searchapibase.activity.*;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩乐混排列表页人工干预报文模板
 * Created by gmluo on 2018/5/10.
 */
public class ActivityInterventionSource extends ActivitySearchSourceBase {
    private String DistrictList_DingweiID;//设置目的地列表下的定位城市信息（目的地）

    private String DistrictList_DistrictID;//设置目的地列表下的站点城市信息（目的地）

    public String getDistrictList_DingweiID() {
        return DistrictList_DingweiID;
    }

    public void setDistrictList_DingweiID(String districtList_DingweiID) {
        DistrictList_DingweiID = districtList_DingweiID;
    }

    public String getDistrictList_DistrictID() {
        return DistrictList_DistrictID;
    }

    public void setDistrictList_DistrictID(String districtList_DistrictID) {
        DistrictList_DistrictID = districtList_DistrictID;
    }

    /**
     * 构造默认报文
     * @return
     */
    public String getActivitySearchSource() {

        /**
         * 获取继承的requestType对象
         */
        ActivitySearchRequestType requestType = super.activityBase();

        /**
         * 重写操作
         * 设置搜索场景5：目的地搜索
         */
        SearchParameter searchParameter = requestType.getSearchParameter();
        searchParameter.setSearchMode(5);


        /**
         * 重写操作
         * 设置排除Wifi产品："47"
         */
        List<ExceptParameter> exceptParameterList = requestType.getExceptList();
        ExceptParameter exceptWiFi = new ExceptParameter();
        exceptWiFi.setType("18");
        exceptWiFi.setValue("47");
        exceptParameterList.add(exceptWiFi);


        /**
         * 重写操作
         * 设置宫格入口：景点玩乐入口（12）
         * 设置是否出推广产品："T"
         */
        List<SortParameter> sortParameterList = requestType.getSortParameterList();
        //3.宫格ID（0:默认；1：景点玩乐宫格混合列表页；2：旅游宫格混合列表页；3：一日游）
        SortParameter spType3 = new SortParameter();
        spType3.setType(3);
        List<String> spValue3 = new ArrayList<String>();
        spValue3.add("12");
        spType3.setValueList(spValue3);
        //4.推广是否置顶（"T" or "F"，默认为"F"）
        SortParameter spType4 = new SortParameter();
        spType4.setType(4);
        List<String> spValue4 = new ArrayList<String>();
        spValue4.add("T");
        spType4.setValueList(spValue4);

        sortParameterList.add(spType3);
        sortParameterList.add(spType4);


        /**
         * 重写操作
         * 设置ExtendedSearchParamList参数
         */
        List<SearchParamDTO> extendedSearchParamList = requestType.getExtendedSearchParamList();
        //是否包含无库存推广区（默认是0），0：不包含，1：包含；
        SearchParamDTO espType1004 = new SearchParamDTO();
        espType1004.setType(1004);
        espType1004.setiD("1");
        espType1004.setWord(null);

        //1006.是否需要300KM产品（默认是0）0：不需要，1：需要
        SearchParamDTO espType1006 = new SearchParamDTO();
        espType1006.setType(1006);
        espType1006.setiD("1");
        espType1006.setWord(null);

        SearchParamDTO espType9 = new SearchParamDTO();
        espType9.setType(9);
        espType9.setiD(DistrictList_DingweiID);
        espType9.setWord(null);

        //目的地列表下的站点城市信息参数设置（目的地）
        SearchParamDTO espType5 = new SearchParamDTO();
        espType5.setType(5);
        espType5.setiD(DistrictList_DistrictID);
        espType5.setWord(null);

        //玩乐目的地列表出门票功能参数设置
        SearchParamDTO espType4 = new SearchParamDTO();
        espType4.setType(4);
        espType4.setiD("2");
        espType4.setWord(null);

        extendedSearchParamList.add(espType1004);
        extendedSearchParamList.add(espType1006);
        extendedSearchParamList.add(espType9);
        extendedSearchParamList.add(espType5);
        extendedSearchParamList.add(espType4);

        /**
         * 将requestType序列化为json类型的String字符
         * 使用fastjson进行序列化操作
         */
        String requestSource = JSON.toJSONString(requestType);
        /**
         * 返回相应的请求报文
         */
        return requestSource;
    }

}
