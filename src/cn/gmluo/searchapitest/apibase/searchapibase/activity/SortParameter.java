package cn.gmluo.searchapitest.apibase.searchapibase.activity;

import java.util.List;

/**
 * Created by gmluo on 2018/3/22.
 */
public class SortParameter {
    Integer type;
    List<String> valueList;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }
}
