package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

import java.util.ArrayList;
import java.util.List;

/**
 * 门票搜索默认报文基类
 * Created by gmluo on 2018/5/2.
 */
public abstract class ScenicSpotSearchSourceBase {

    protected ScenicSpotSearchRequestType scenicspotBase(){
        /**
         * 构造SearchParameter默认参数
         */
        ScenicSpotSearchRequestType requestType =new ScenicSpotSearchRequestType();
        SearchParameter searchParameter=new SearchParameter();
        searchParameter.setKeyword("");
        searchParameter.setLongitude(0.0);
        searchParameter.setLatitude(0.0);
        searchParameter.setRangeMinimum(0.0);
        searchParameter.setRangeMaximum(0.0);
        searchParameter.setReturnDistance(false);
        searchParameter.setPayMode(0);
        searchParameter.setAvailableToday(false);
        List<String> aBTestType = new ArrayList<String>();
        searchParameter.setaBTestType(aBTestType);
        searchParameter.setSearchMode(0);
        searchParameter.setSite(null);

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
         * 构造SortParameter默认参数(默认排序；出推广产品)
         */
        SortParameter sortParameter=new SortParameter();
        //配置默认排序参数
        sortParameter.setThemeLabelSort(0);
        sortParameter.setSortType("D");
        sortParameter.setSortDirection(null);

        //配置出推广参数
        List<CustomerSortParameter> customerSortParameterList=new ArrayList<CustomerSortParameter>();
        CustomerSortParameter tuiguangSortParameter=new CustomerSortParameter();
        tuiguangSortParameter.setType("4");
        tuiguangSortParameter.setValue("T");
        customerSortParameterList.add(tuiguangSortParameter);
        sortParameter.setCustomerSortList(customerSortParameterList);



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
         * 构造ExtendedSearchParamList参数
         */
        List<SearchParamDTO> extendedSearchParamList = new ArrayList<SearchParamDTO>();

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
        Boolean isDebug = true;

        requestType.setSearchParameter(searchParameter);
        requestType.setFilterList(filterList);
        requestType.setExceptList(exceptList);
        requestType.setStatisticTypeList(statisticTypeList);
        requestType.setSortParameter(sortParameter);
        requestType.setPagingParameter(pagingParameter);
        requestType.setFieldList(fieldList);
        requestType.setExtendedSearchParamList(extendedSearchParamList);
        requestType.setDistributionChannelID(distributionChannelID);
        requestType.setaBTestInfo(aBTestInfo);
        requestType.setIsDebug(isDebug);

        return requestType;

    }
}
