package cn.gmluo.searchapitest.requestsource.searchapisource.activity.district;


import cn.gmluo.searchapitest.apibase.searchapibase.activity.ActivitySearchRequestType;
import cn.gmluo.searchapitest.apibase.searchapibase.activity.ActivitySearchSourceBase;
import cn.gmluo.searchapitest.apibase.searchapibase.activity.SearchParamDTO;
import cn.gmluo.searchapitest.apibase.searchapibase.activity.SearchParameter;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 玩乐目的地列表页默认报文模板
 * Created by gmluo on 2018/5/10.
 */
public class DistrictListSearchSource extends ActivitySearchSourceBase {
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
     *
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
        //目的地列表搜索参数设置（SearchMode=5）
        searchParameter.setSearchMode(5);

        /**
         * 重写操作
         * 设置ExtendedSearchParamList参数
         */
        //目的地列表下的定位城市信息参数设置（目的地）
        List<SearchParamDTO> extendedSearchParamList = requestType.getExtendedSearchParamList();
        SearchParamDTO type9 = new SearchParamDTO();
        type9.setType(9);
        type9.setiD(DistrictList_DingweiID);
        type9.setWord(null);

        //目的地列表下的站点城市信息参数设置（目的地）
        SearchParamDTO type5 = new SearchParamDTO();
        type5.setType(5);
        type5.setiD(DistrictList_DistrictID);
        type5.setWord(null);

        //玩乐目的地列表出门票功能参数设置
        SearchParamDTO type4 = new SearchParamDTO();
        type4.setType(4);
        type4.setiD("2");
        type4.setWord(null);
        extendedSearchParamList.add(type9);
        extendedSearchParamList.add(type5);
        extendedSearchParamList.add(type4);


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
