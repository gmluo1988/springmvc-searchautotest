package cn.gmluo.searchapitest.apibase.searchapibase.autocomplete;

/**
 * 景点搜索过滤参数类型
 * Created by gmluo on 2018/5/2.
 */
public class FilterParameter {
    /**
     * 1、产品来源(1：门票景点 2：纯玩乐景点 只在纯门票场景下有效)
     * 2、是否出产品名称(0：不出 1：出 只有在非纯门票场景下有效)
     */
    public String type;

    public String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
