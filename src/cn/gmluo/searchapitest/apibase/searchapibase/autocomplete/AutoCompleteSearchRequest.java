package cn.gmluo.searchapitest.apibase.searchapibase.autocomplete;

import java.util.List;

/**
 * 联想词请求参数
 * Created by gmluo on 2018/5/2.
 */
public class AutoCompleteSearchRequest {
    /**
     * 关键字
     */
    public String keyword;

    /**
     * 起价渠道ID，搜索时根据渠道进行搜索。目前有：0-默认，2-Online预订，5-无线App, 7-无线Html5，9-分销
     */
    public Integer distributionChannel;

    /**
     * 搜索类型：1、地面 2、纯门票 3、纯玩乐 4、玩乐混排门票 5、只出一日游产品 6、只出攻略目的地ID
     */
    public Integer searchType;

    /**
     * 站点城市-酒店城市ID
     */
    public Integer cityID;

    /**
     * 站点城市-攻略目的地ID
     */
    public Long districtId;

    /**
     * 定位城市-酒店城市ID
     */
    public Long locationCityId;

    /**
     * 定位城市-攻略目的地ID
     */
    public Long locationDistrictId;

    /**
     * 所在位置经度，精确到小数后6位，默认0
     */
    public Double lon;

    /**
     * 所在位置纬度，精确到小数后6位，默认0
     */
    public Double lat;

    /**
     * 坐标系，默认0（0：高德，1：百度，2：google）
     */
    public Integer csType;

    /**
     * 获取联想词记录数（废弃）
     */
    public Integer limit;

    /**
     * 指定ABTest试验号及版本，例如：160127_act_lista:B，就会走指定的160127_act_lista实验的B版本
     */
    public List<String> aBTestType;

    /**
     * AB test信息
     */
    public List<ABTestParameter> aBTestInfo;

    /**
     * 是否出免费景点：0、不出免费景点 1、出非免费和免费景点
     */
    public Integer containNonSalePoiType;

    /**
     * 是否显示提示语：0、不显示（默认） 1、显示
     */
    public Integer displayRecTipType;

    /**
     * 过滤参数
     */
    public List<FilterParameter> filterList;

    /**
     * debug开关
     */
    public Boolean isDebug;


    public List<FilterParameter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<FilterParameter> filterList) {
        this.filterList = filterList;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getDistributionChannel() {
        return distributionChannel;
    }

    public void setDistributionChannel(Integer distributionChannel) {
        this.distributionChannel = distributionChannel;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public Long getLocationCityId() {
        return locationCityId;
    }

    public void setLocationCityId(Long locationCityId) {
        this.locationCityId = locationCityId;
    }

    public Long getLocationDistrictId() {
        return locationDistrictId;
    }

    public void setLocationDistrictId(Long locationDistrictId) {
        this.locationDistrictId = locationDistrictId;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getCsType() {
        return csType;
    }

    public void setCsType(Integer csType) {
        this.csType = csType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<String> getaBTestType() {
        return aBTestType;
    }

    public void setaBTestType(List<String> aBTestType) {
        this.aBTestType = aBTestType;
    }

    public List<ABTestParameter> getaBTestInfo() {
        return aBTestInfo;
    }

    public void setaBTestInfo(List<ABTestParameter> aBTestInfo) {
        this.aBTestInfo = aBTestInfo;
    }

    public Integer getContainNonSalePoiType() {
        return containNonSalePoiType;
    }

    public void setContainNonSalePoiType(Integer containNonSalePoiType) {
        this.containNonSalePoiType = containNonSalePoiType;
    }

    public Integer getDisplayRecTipType() {
        return displayRecTipType;
    }

    public void setDisplayRecTipType(Integer displayRecTipType) {
        this.displayRecTipType = displayRecTipType;
    }

    public Boolean getIsDebug() {
        return isDebug;
    }

    public void setIsDebug(Boolean debug) {
        isDebug = debug;
    }
}
