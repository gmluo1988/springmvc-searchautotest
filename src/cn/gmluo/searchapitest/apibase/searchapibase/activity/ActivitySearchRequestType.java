package cn.gmluo.searchapitest.apibase.searchapibase.activity;

import java.util.List;

/**
 * Created by gmluo on 2018/3/22.
 */
public class ActivitySearchRequestType {
    SearchParameter searchParameter;
    List<FilterParameter> filterList;
    List<ExceptParameter> exceptList;
    List<Integer> statisticTypeList;
    PagingParameter pagingParameter;
    List<String> fieldList;
    List<SortParameter> sortParameterList;
    List<SearchParamDTO> extendedSearchParamList;
    Integer sort;
    Integer distributionChannelID;
    List<ABTestParameter> aBTestInfo;
    Boolean isDebug;

    public SearchParameter getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(SearchParameter searchParameter) {
        this.searchParameter = searchParameter;
    }

    public List<FilterParameter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FilterParameter> filterList) {
        this.filterList = filterList;
    }

    public List<ExceptParameter> getExceptList() {
        return exceptList;
    }

    public void setExceptList(List<ExceptParameter> exceptList) {
        this.exceptList = exceptList;
    }

    public List<Integer> getStatisticTypeList() {
        return statisticTypeList;
    }

    public void setStatisticTypeList(List<Integer> statisticTypeList) {
        this.statisticTypeList = statisticTypeList;
    }

    public PagingParameter getPagingParameter() {
        return pagingParameter;
    }

    public void setPagingParameter(PagingParameter pagingParameter) {
        this.pagingParameter = pagingParameter;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public List<SortParameter> getSortParameterList() {
        return sortParameterList;
    }

    public void setSortParameterList(List<SortParameter> sortParameterList) {
        this.sortParameterList = sortParameterList;
    }

    public List<SearchParamDTO> getExtendedSearchParamList() {
        return extendedSearchParamList;
    }

    public void setExtendedSearchParamList(List<SearchParamDTO> extendedSearchParamList) {
        this.extendedSearchParamList = extendedSearchParamList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDistributionChannelID() {
        return distributionChannelID;
    }

    public void setDistributionChannelID(Integer distributionChannelID) {
        this.distributionChannelID = distributionChannelID;
    }

    public List<ABTestParameter> getaBTestInfo() {
        return aBTestInfo;
    }

    public void setaBTestInfo(List<ABTestParameter> aBTestInfo) {
        this.aBTestInfo = aBTestInfo;
    }

    public Boolean getIsDebug() {
        return isDebug;
    }

    public void setIsDebug(Boolean debug) {
        isDebug = debug;
    }
}
