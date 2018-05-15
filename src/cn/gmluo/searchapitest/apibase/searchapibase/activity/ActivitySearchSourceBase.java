package cn.gmluo.searchapitest.apibase.searchapibase.activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩乐搜索默认报文基类
 * Created by gmluo on 2018/3/22.
 */
public abstract class ActivitySearchSourceBase {
    /**
     * 方法一：步骤1
     * 构造玩乐接口默认报文参数activityBase
     *
     * @return
     */
    protected ActivitySearchRequestType activityBase() {
        ActivitySearchRequestType requestType = new ActivitySearchRequestType();

        /**
         * 构造SearchParameter默认参数
         */
        SearchParameter searchParameter = new SearchParameter();
        searchParameter.setKeyword("");
        searchParameter.setLongitude(0.0);
        searchParameter.setLatitude(0.0);
        searchParameter.setRangeMinimum(0.0);
        searchParameter.setRangeMaximum(0.0);
        searchParameter.setPayMode(0);
        searchParameter.setAvailableToday(false);
        List<String> aBTestType = new ArrayList<String>();
        searchParameter.setaBTestType(aBTestType);
        searchParameter.setSearchMode(0);

        /**
         * 构造FilterList默认参数
         */
        List<FilterParameter> filterList = new ArrayList<FilterParameter>();

        /**
         * 构造ExceptList默认参数
         */
        List<ExceptParameter> exceptList = new ArrayList<ExceptParameter>();

        /**
         * 构造StatisticTypeList默认参数
         */
        List<Integer> statisticTypeList = new ArrayList<Integer>();
        statisticTypeList.add(-1);

        /**
         * 构造PagingParameter默认参数
         */
        PagingParameter pagingParameter = new PagingParameter();
        pagingParameter.setPageIndex(1);
        pagingParameter.setPageSize(3000);//设置一次请求返回2000条数据

        /**
         * 构造FieldList参数
         */
        List<String> fieldList = new FieldList().getFieldList();

        /**
         * 构造SortParameterList默认参数
         */
        List<SortParameter> sortParameterList = new ArrayList<SortParameter>();


        /**
         * 构造ExtendedSearchParamList参数
         */
        List<SearchParamDTO> extendedSearchParamList = new ArrayList<SearchParamDTO>();

        /**
         * 构造Sort默认参数
         */
        Integer sort = 0;

        /**
         * 构造DistributionChannelID默认参数
         */
        Integer distributionChannelID = 5;

        /**
         * 构造ABTestInfo默认参数
         */
        List<ABTestParameter> aBTestInfo = new ArrayList<ABTestParameter>();

        /**
         * 构造IsDebug默认参数
         */
        Boolean isDebug = false;

        requestType.setSearchParameter(searchParameter);
        requestType.setFilterList(filterList);
        requestType.setExceptList(exceptList);
        requestType.setStatisticTypeList(statisticTypeList);
        requestType.setPagingParameter(pagingParameter);
        requestType.setFieldList(fieldList);
        requestType.setSortParameterList(sortParameterList);
        requestType.setExtendedSearchParamList(extendedSearchParamList);
        requestType.setSort(sort);
        requestType.setDistributionChannelID(distributionChannelID);
        requestType.setaBTestInfo(aBTestInfo);
        requestType.setIsDebug(false);

        return requestType;

    }


    /**
     * 方法二：步骤1
     * 设置玩乐接口请求报文的默认参数
     * @return
     */
//    protected String getJsonSource(){
//        ActivitySearchRequestType requestType = new ActivitySearchRequestType();
//
//        /**
//         * 构造SearchParameter默认参数
//         */
//        SearchParameter searchParameter = new SearchParameter();
//        searchParameter.setKeyword("");
//        searchParameter.setLongitude(0.0);
//        searchParameter.setLatitude(0.0);
//        searchParameter.setRangeMinimum(0.0);
//        searchParameter.setRangeMaximum(0.0);
//        searchParameter.setPayMode(0);
//        searchParameter.setAvailableToday(false);
//        List<String> aBTestType=new ArrayList<String>();
//        searchParameter.setaBTestType(aBTestType);
//        searchParameter.setSearchMode(0);
//
//        /**
//         * 构造FilterList默认参数
//         */
//        List<FilterParameter> filterList =new ArrayList<FilterParameter>();
//
//        /**
//         * 构造ExceptList默认参数
//         */
//        List<ExceptParameter> exceptList=new ArrayList<ExceptParameter>();
//
//        /**
//         * 构造StatisticTypeList默认参数
//         */
//        List<Integer> statisticTypeList = new ArrayList<Integer>();
//        statisticTypeList.add(-1);
//
//        /**
//         * 构造PagingParameter默认参数
//         */
//        PagingParameter pagingParameter = new PagingParameter();
//        pagingParameter.setPageIndex(1);
//        pagingParameter.setPageSize(2000);
//
//        /**
//         * 构造FieldList参数
//         */
//        List<String> fieldList = new ArrayList<String>();
//        fieldList.add("ActivityName");
//
//        /**
//         * 构造SortParameterList默认参数
//         */
//        List<SortParameter> sortParameterList=new ArrayList<SortParameter>();
//
//
//        /**
//         * 构造ExtendedSearchParamList参数
//         */
//        List<SearchParamDTO> extendedSearchParamList = new ArrayList<SearchParamDTO>();
//
//        /**
//         * 构造Sort默认参数
//         */
//        Integer sort=0;
//
//        /**
//         * 构造DistributionChannelID默认参数
//         */
//        Integer distributionChannelID=5;
//
//        /**
//         * 构造ABTestInfo默认参数
//         */
//        List<ABTestParameter> aBTestInfo =new ArrayList<ABTestParameter>();
//
//        /**
//         * 构造IsDebug默认参数
//         */
//        Boolean isDebug=false;
//
//        requestType.setSearchParameter(searchParameter);
//        requestType.setFilterList(filterList);
//        requestType.setExceptList(exceptList);
//        requestType.setStatisticTypeList(statisticTypeList);
//        requestType.setPagingParameter(pagingParameter);
//        requestType.setFieldList(fieldList);
//        requestType.setSortParameterList(sortParameterList);
//        requestType.setExtendedSearchParamList(extendedSearchParamList);
//        requestType.setSort(sort);
//        requestType.setDistributionChannelID(distributionChannelID);
//        requestType.setaBTestInfo(aBTestInfo);
//        requestType.setDebug(false);
//
//        String jsonSource = JSON.toJSONString(requestType);
//
//        return jsonSource;
//    }
}
