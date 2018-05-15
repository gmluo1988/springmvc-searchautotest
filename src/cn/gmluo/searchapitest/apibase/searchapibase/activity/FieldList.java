package cn.gmluo.searchapitest.apibase.searchapibase.activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gmluo on 2018/3/26.
 */
public class FieldList {
    /**
     * 返回所有需要字段
     */
    List<String> fieldList = new ArrayList<String>();

    public List<String> getFieldList() {
        fieldList.add("ActivityName");
        fieldList.add("CategoryIDs");

        fieldList.add("CommentScore");
        fieldList.add("SalesVolumeLast30Days");
        fieldList.add("SalePrice");

        fieldList.add("TodayCanBookingLastTime");
        fieldList.add("UseDate");
        fieldList.add("NextCanBookingDate");

        fieldList.add("PayMode");
        fieldList.add("ActivityTimeSpanRangeIDs");
        fieldList.add("SalesPriceRangeIDs");
        fieldList.add("ActivityTagIDs");
        fieldList.add("Properties");
        fieldList.add("SpecialTags");
        fieldList.add("PromotionIDs");

        fieldList.add("AdTopCityIDs");
        fieldList.add("AdTopDistrictIDs");
        fieldList.add("AdTopKeywords");
        fieldList.add("InsidePoiType");

        fieldList.add("activityProValues");
        fieldList.add("DescrProperties");
        fieldList.add("ChannelStockStatus");
        fieldList.add("ImgUrl");

        fieldList.add("Adjustment");
        fieldList.add("TagIDs");
        fieldList.add("ThemeIDs");
        fieldList.add("PoiIDs");
        fieldList.add("LanguageIDs");


        fieldList.add("LocationType");
        fieldList.add("LocationDistrictIDs");
        fieldList.add("DestinationDistrictIDs");
        fieldList.add("CityIDs");
        fieldList.add("DestinationCityIDs");
        fieldList.add("DestinationProvinceIDs");
        fieldList.add("DestinationCountryIDs");
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }
}
