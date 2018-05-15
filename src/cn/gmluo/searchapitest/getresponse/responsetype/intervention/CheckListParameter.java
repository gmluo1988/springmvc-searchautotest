package cn.gmluo.searchapitest.getresponse.responsetype.intervention;

/**
 * 每个列表页的验证结果返回对象
 * Created by gmluo on 2018/5/11.
 */
public class CheckListParameter {
    /**
     * 验证的列表页名称
     */
    private String checkList;

    /**
     * 验证的目的地数量
     */
    private int districtCount;

    /**
     * 验证的总产品数
     */
    private int productCount;

    /**
     * 验证正确排序产品数
     */
    private int successCount;

    /**
     * 验证排序失败产品数
     */
    private int failCount;

    /**
     * 搜索接口无返回的产品数（nar=no api return）
     */
    private int narCount;

    /**
     * 本身为推广产品数(tg=tuiguang)
     */
    private int tgCount;


    @Override
    public String toString() {
        return "CheckListParameter{" +
                "checkList='" + checkList + '\'' +
                ", districtCount=" + districtCount +
                ", productCount=" + productCount +
                ", successCount=" + successCount +
                ", failCount=" + failCount +
                ", narCount=" + narCount +
                ", tgCount=" + tgCount +
                '}';
    }

    public String getCheckList() {
        return checkList;
    }

    public void setCheckList(String checkList) {
        this.checkList = checkList;
    }

    public int getDistrictCount() {
        return districtCount;
    }

    public void setDistrictCount(int districtCount) {
        this.districtCount = districtCount;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(int successCount) {
        this.successCount = successCount;
    }

    public int getFailCount() {
        return failCount;
    }

    public void setFailCount(int failCount) {
        this.failCount = failCount;
    }

    public int getNarCount() {
        return narCount;
    }

    public void setNarCount(int narCount) {
        this.narCount = narCount;
    }

    public int getTgCount() {
        return tgCount;
    }

    public void setTgCount(int tgCount) {
        this.tgCount = tgCount;
    }
}
