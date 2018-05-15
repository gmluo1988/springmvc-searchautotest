package cn.gmluo.searchapitest.apibase.searchapibase.activity;

/**
 * Created by gmluo on 2018/3/22.
 */
public class PagingParameter {
    Integer pageIndex;
    Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
