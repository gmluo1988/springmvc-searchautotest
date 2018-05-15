package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

import java.util.List;

/**
 * 景点搜索请求类型
 * Created by gmluo on 2018/5/2.
 */
public class ScenicSpotSearchRequestType {
    /**
     * 主搜索参数
     */
    public SearchParameter searchParameter;

    /**
     * 过滤参数
     */
    public List<FilterParameter> filterList;

    /**
     * 排除参数
     */
    public List<ExceptParameter> exceptList;

    /**
     * 标签统计
     */
    public List<Integer> statisticTypeList;

    /**
     * 排序参数
     */
    public SortParameter sortParameter;

    /**
     * 分页参数
     */
    public PagingParameter pagingParameter;

    public List<String> fieldList;

    /**
     * 搜索扩展参数
     */
    public List<SearchParamDTO> extendedSearchParamList;

    /**
     * 销售渠道（1-一卡代理；2-online预订；3-offline预订；4-订单处理；5-无线APP；6-英文；7-无线Html5；8-无线优惠；9：分销；11：机+酒；12：景+酒；13：金融；14：酒店；15：团购）
     */
    public Integer distributionChannelID;

    /**
     * AB test信息
     */
    public List<ABTestParameter> aBTestInfo;

    /**
     * 是否开启调试模式
     */
    public Boolean isDebug;

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

    public SortParameter getSortParameter() {
        return sortParameter;
    }

    public void setSortParameter(SortParameter sortParameter) {
        this.sortParameter = sortParameter;
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

    public List<SearchParamDTO> getExtendedSearchParamList() {
        return extendedSearchParamList;
    }

    public void setExtendedSearchParamList(List<SearchParamDTO> extendedSearchParamList) {
        this.extendedSearchParamList = extendedSearchParamList;
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
