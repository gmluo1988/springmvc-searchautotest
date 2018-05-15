package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

import java.util.List;

/**
 * 景点搜索排序参数类型SortParameter部分
 * Created by gmluo on 2018/5/2.
 */
public class SortParameter {

    /**
     * 主题标签排序（0：默认逻辑，1：按原有salesvolumelast30days字段和排序。2：周边+本地历史订单30天销量排序）
     */

    public Integer themeLabelSort;

    /**
     * 排序类型（D-默认排序；R-点评分排序；S-距离排序；L-等级排序；P-价格排序；C－点评数；V-30天销量；DR- 折扣率; CS-周边城市销量和排序）;
     * DD-距离智能排序-默认;
     * Y-年销量排序
     */
    public String sortType;

    /**
     * 降序或升序（A-升序；D-降序）
     */
    public String sortDirection;

    /**
     * 排序加强条件（只作用于排序类型为D）
     */
    public List<CustomerSortParameter> customerSortList;


    public Integer getThemeLabelSort() {
        return themeLabelSort;
    }

    public void setThemeLabelSort(Integer themeLabelSort) {
        this.themeLabelSort = themeLabelSort;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public List<CustomerSortParameter> getCustomerSortList() {
        return customerSortList;
    }

    public void setCustomerSortList(List<CustomerSortParameter> customerSortList) {
        this.customerSortList = customerSortList;
    }
}
