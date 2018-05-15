package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

/**
 * 景点搜索分页参数类型(注：当PageIndex,PageSize 都为0 的时候，只返回统计信息，不返回景点信息)
 * Created by gmluo on 2018/5/2.
 */
public class PagingParameter {
    /**
     * 页码
     */
    public Integer pageIndex;

    /**
     * 分页大小
     */
    public Integer pageSize;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
