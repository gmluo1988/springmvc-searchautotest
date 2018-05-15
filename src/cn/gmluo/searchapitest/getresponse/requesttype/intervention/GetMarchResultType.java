package cn.gmluo.searchapitest.getresponse.requesttype.intervention;

/**
 * Created by gmluo on 2018/5/14.
 */
public class GetMarchResultType {
    private Integer searchType;
    private Integer testStatus;
    private Integer pageIndex;
    private Integer pageSize;

    @Override
    public String toString() {
        return "GetMarchResultType{" +
                "searchType=" + searchType +
                ", testStatus=" + testStatus +
                ", pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(Integer testStatus) {
        this.testStatus = testStatus;
    }

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
