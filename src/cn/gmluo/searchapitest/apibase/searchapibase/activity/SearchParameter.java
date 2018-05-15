package cn.gmluo.searchapitest.apibase.searchapibase.activity;

import java.util.List;

/**
 * Created by gmluo on 2018/3/22.
 */
public class SearchParameter {
    String keyword;
    Double longitude;
    Double latitude;
    Double rangeMinimum;
    Double rangeMaximum;
    Integer payMode;
    Boolean isAvailableToday;
    List<String> aBTestType;
    Integer searchMode;

    @Override
    public String toString() {
        return "SearchParameter{" +
                "keyword='" + keyword + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", rangeMinimum=" + rangeMinimum +
                ", rangeMaximum=" + rangeMaximum +
                ", payMode=" + payMode +
                ", isAvailableToday=" + isAvailableToday +
                ", aBTestType=" + aBTestType +
                ", searchMode=" + searchMode +
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
}
