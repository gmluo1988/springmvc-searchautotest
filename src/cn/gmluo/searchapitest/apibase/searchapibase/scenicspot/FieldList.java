package cn.gmluo.searchapitest.apibase.searchapibase.scenicspot;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回字段列表   (如果有isadtop字段， 指定该产品是推广的。)
 * Created by gmluo on 2018/5/2.
 */
public class FieldList {
    /**
     * 返回所有需要字段
     */
    List<String> fieldList = new ArrayList<String>();

    public List<String> getFieldList() {
        fieldList.add("Name");
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }
}
