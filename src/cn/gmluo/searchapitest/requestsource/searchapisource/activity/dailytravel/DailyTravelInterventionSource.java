package cn.gmluo.searchapitest.requestsource.searchapisource.activity.dailytravel;

import cn.gmluo.searchapitest.apibase.searchapibase.activity.*;
import com.alibaba.fastjson.JSON;


import java.util.ArrayList;
import java.util.List;

/**
 * 玩乐一日游列表页人工干预报文模板
 * Created by gmluo on 2018/5/10.
 */
public class DailyTravelInterventionSource extends ActivitySearchSourceBase {
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
        searchParameter.setSearchMode(5);


        /**
         * 重写操作
         * 设置筛选一日游产品："40"
         */
        List<FilterParameter> filterParameterList = requestType.getFilterList();
        FilterParameter filterParameter = new FilterParameter();
        filterParameter.setType("24");
        filterParameter.setValue("40");
        filterParameterList.add(filterParameter);

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
        spValue3.add("13");
        spType3.setValueList(spValue3);
        sortParameterList.add(spType3);


        /**
         * 重写操作
         * 设置ExtendedSearchParamList参数
         */
        List<SearchParamDTO> extendedSearchParamList = requestType.getExtendedSearchParamList();

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

        extendedSearchParamList.add(espType1006);
        extendedSearchParamList.add(espType9);
        extendedSearchParamList.add(espType5);

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
