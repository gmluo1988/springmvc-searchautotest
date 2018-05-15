package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

/**
 * 景点搜索排序加强排序参数类型
 * Created by gmluo on 2018/5/2.
 */
public class CustomerSortParameter {

    /**
     * 1.SiteName,2.POI主题ID ,3 POI主题Name 4：是否出推广（"T" or "F"，默认为"F"）
     */
    public String type;

    /**
     * 值
     */
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
