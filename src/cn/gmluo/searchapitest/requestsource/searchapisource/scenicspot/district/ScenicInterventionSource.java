package cn.gmluo.searchapitest.requestsource.searchapisource.scenicspot.district;


import cn.gmluo.searchapitest.apibase.searchapibase.scenicspot.*;
import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * 门票目的地列表页人工干预报文模板
 * Created by gmluo on 2018/5/10.
 */
public class ScenicInterventionSource extends ScenicSpotSearchSourceBase {
    private String districtID;

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getScenicSearchSource() {
        /**
         * 获取继承的requestType对象
         */
        ScenicSpotSearchRequestType requestType = super.scenicspotBase();
        /**
         * 针对requestType对象进行相应的数据重写
         * 需要构造什么报文就变更相应地方的数据即可
         */

        /**
         * 重写操作
         * 设置搜索场景7：目的地搜索
         */
        SearchParameter searchParameter = requestType.getSearchParameter();
        searchParameter.setSearchMode(7);

        /**
         * 重写操作
         * 设置目的地参数：districtID
         */
        List<FilterParameter> filterParameterList = requestType.getFilterList();
        FilterParameter filterParameter = new FilterParameter();
        filterParameter.setType("8");
        filterParameter.setValue(districtID);

        filterParameterList.add(filterParameter);

        /**
         *重写操作
         *设置默认排序
         */
        SortParameter sortParameter = requestType.getSortParameter();

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
