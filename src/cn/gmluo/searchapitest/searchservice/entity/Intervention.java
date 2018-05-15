package cn.gmluo.searchapitest.searchservice.entity;


import java.sql.Date;

/**
 * 1.数据实例层设计
 * Created by gmluo on 2018/5/10.
 */
public class Intervention {
    //主键，自增长id
    private int id;

    //搜索列表页1：门票；2：混排；3：一日游
    private int searchType;

    //人工干预的目的地id
    private Integer districtId;

    //人工干预的产品id
    private Long productId;

    //人工干预排序位置
    private int sortOrder;

    //搜索接口中的排序位置
    private int searchApiOrder;

    //是否是推广产品
    private Boolean tuiguang;

    //搜索接口中是否有返回该产品
    private Boolean apiReturn;

    //排序是否正确
    private Boolean march;

    //验证状态1：success;2:fail;3:推广产品;4:搜索接口无返回
    private int testStatus;

    //验证日期
    private Date testDate;

    @Override
    public String toString() {
        return "Intervention{" +
                "id=" + id +
                ", searchType=" + searchType +
                ", districtId=" + districtId +
                ", productId=" + productId +
                ", sortOrder=" + sortOrder +
                ", searchApiOrder=" + searchApiOrder +
                ", tuiguang=" + tuiguang +
                ", apiReturn=" + apiReturn +
                ", march=" + march +
                ", testStatus=" + testStatus +
                ", testDate=" + testDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSearchType() {
        return searchType;
    }

    public void setSearchType(int searchType) {
        this.searchType = searchType;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getSearchApiOrder() {
        return searchApiOrder;
    }

    public void setSearchApiOrder(int searchApiOrder) {
        this.searchApiOrder = searchApiOrder;
    }

    public Boolean getTuiguang() {
        return tuiguang;
    }

    public void setTuiguang(Boolean tuiguang) {
        this.tuiguang = tuiguang;
    }

    public Boolean getApiReturn() {
        return apiReturn;
    }

    public void setApiReturn(Boolean apiReturn) {
        this.apiReturn = apiReturn;
    }

    public Boolean getMarch() {
        return march;
    }

    public void setMarch(Boolean march) {
        this.march = march;
    }

    public int getTestStatus() {
        return testStatus;
    }

    public void setTestStatus(int testStatus) {
        this.testStatus = testStatus;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }
}
