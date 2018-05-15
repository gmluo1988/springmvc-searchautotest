package cn.gmluo.searchapitest.apibase.searchapibase.autocomplete;

/**
 * AB test传值信息
 * Created by gmluo on 2018/5/2.
 */
public class ABTestParameter {
    /**
     * key：SystemCode 系统编号（版本） ClientVersion 客户端版本 ClientToken ClientCode
     */
    public String key;

    public String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
