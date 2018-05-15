package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

import java.util.List;

/**
 * 景点搜索参数类型SearchParameter部分
 * Created by gmluo on 2018/5/2.
 */
public class SearchParameter {
    /**
     * 搜索关键词
     */
    String keyword;
    /**
     * 所在位置经度，范围（-180，180)高德
     */
    Double longitude;
    /**
     * 所在位置纬度，范围（-90，90）高德
     */
    Double latitude;
    /**
     * 最小距离(千米)
     */
    Double rangeMinimum;
    /**
     * 最大距离(千米)
     */
    Double rangeMaximum;
    /**
     * 是否返回距离
     */
    Boolean isReturnDistance;
    /**
     * ( 0.全部, 1.现付，2.预付) 未赋值就是全部
     */
    Integer payMode;
    /**
     * false:全部 true：当天可预订
     */
    Boolean isAvailableToday;
    /**
     * 测试类型:A,B；格式: “ABTest实验ID：ABTest实验版本”
     */
    List<String> aBTestType;

    /**
     * 搜索类型：
     * 0：默认逻辑，
     * 1：只取周边
     * 2：只取本地
     * 3：周边加本地（1,2,3时，必须传入城市ID），
     * 4：关键字，
     * 5：附近，
     * 6：景点补偿,
     * 7：攻略目的地查询
     */
    Integer searchMode;
    /**
     * 站点名称
     */
    String site;

    @Override
    public String toString() {
        return "SearchParameter{" +
                "keyword='" + keyword + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", rangeMinimum=" + rangeMinimum +
                ", rangeMaximum=" + rangeMaximum +
                ", isReturnDistance=" + isReturnDistance +
                ", payMode=" + payMode +
                ", isAvailableToday=" + isAvailableToday +
                ", aBTestType=" + aBTestType +
                ", searchMode=" + searchMode +
                ", site='" + site + '\'' +
                '}';
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getRangeMinimum() {
        return rangeMinimum;
    }

    public void setRangeMinimum(Double rangeMinimum) {
        this.rangeMinimum = rangeMinimum;
    }

    public Double getRangeMaximum() {
        return rangeMaximum;
    }

    public void setRangeMaximum(Double rangeMaximum) {
        this.rangeMaximum = rangeMaximum;
    }

    public Boolean getReturnDistance() {
        return isReturnDistance;
    }

    public void setReturnDistance(Boolean returnDistance) {
        isReturnDistance = returnDistance;
    }

    public Integer getPayMode() {
        return payMode;
    }

    public void setPayMode(Integer payMode) {
        this.payMode = payMode;
    }

    public Boolean getAvailableToday() {
        return isAvailableToday;
    }

    public void setAvailableToday(Boolean availableToday) {
        isAvailableToday = availableToday;
    }

    public List<String> getaBTestType() {
        return aBTestType;
    }

    public void setaBTestType(List<String> aBTestType) {
        this.aBTestType = aBTestType;
    }

    public Integer getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(Integer searchMode) {
        this.searchMode = searchMode;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
}
