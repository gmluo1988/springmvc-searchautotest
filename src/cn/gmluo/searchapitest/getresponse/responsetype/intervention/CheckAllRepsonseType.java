package cn.gmluo.searchapitest.getresponse.responsetype.intervention;

import java.util.List;

/**
 * 所有列表页的验证结果返回对象
 * Created by gmluo on 2018/5/10.
 */
public class CheckAllRepsonseType {
    /**
     * 验证的列表页集合
     */
    private List<String> checkLists;

    /**
     * 验证的目的地总数
     */
    private int totalDistrictCount;

    /**
     * 验证的总产品数
     */
    private int totalProductCount;

    /**
     * 验证正确产品总数
     */
    private int totalSuccessCount;

    /**
     * 验证失败产品总数数
     */
    private int totalFailCount;

    /**
     * 搜索接口无返回的产品总数（NAR=No Api Return）
     */
    private int totalNARCount;

    /**
     * 本身为推广产品总数数(TG=tuiguang)
     */
    private int totalTGCount;

    /**
     * 每个列表页验证结果集
     */
    private List<CheckListParameter> checkListParameters;

    @Override
    public String toString() {
        return "CheckAllRepsonseType{" +
                "checkLists=" + checkLists +
                ", totalDistrictCount=" + totalDistrictCount +
                ", totalProductCount=" + totalProductCount +
                ", totalSuccessCount=" + totalSuccessCount +
                ", totalFailCount=" + totalFailCount +
                ", totalNARCount=" + totalNARCount +
                ", totalTGCount=" + totalTGCount +
                ", checkListParameters=" + checkListParameters +
                '}';
    }

    public int getTotalSuccessCount() {
        return totalSuccessCount;
    }

    public void setTotalSuccessCount(int totalSuccessCount) {
        this.totalSuccessCount = totalSuccessCount;
    }

    public List<String> getCheckLists() {
        return checkLists;
    }

    public void setCheckLists(List<String> checkLists) {
        this.checkLists = checkLists;
    }

    public int getTotalDistrictCount() {
        return totalDistrictCount;
    }

    public void setTotalDistrictCount(int totalDistrictCount) {
        this.totalDistrictCount = totalDistrictCount;
    }

    public int getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(int totalProductCount) {
        this.totalProductCount = totalProductCount;
    }

    public int getTotalFailCount() {
        return totalFailCount;
    }

    public void setTotalFailCount(int totalFailCount) {
        this.totalFailCount = totalFailCount;
    }

    public int getTotalNARCount() {
        return totalNARCount;
    }

    public void setTotalNARCount(int totalNARCount) {
        this.totalNARCount = totalNARCount;
    }

    public int getTotalTGCount() {
        return totalTGCount;
    }

    public void setTotalTGCount(int totalTGCount) {
        this.totalTGCount = totalTGCount;
    }

    public List<CheckListParameter> getCheckListParameters() {
        return checkListParameters;
    }

    public void setCheckListParameters(List<CheckListParameter> checkListParameters) {
        this.checkListParameters = checkListParameters;
    }
}
