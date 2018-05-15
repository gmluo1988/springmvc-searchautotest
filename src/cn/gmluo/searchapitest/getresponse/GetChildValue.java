package cn.gmluo.searchapitest.getresponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gmluo on 2018/3/23.
 */
public class GetChildValue {
    /**
     * 获取返回结果中的所有String类型值存进stringValueList
     *
     * @param jsonArray
     * @param stringValue
     * @return
     */
    public List<String> getStringValueList(JSONArray jsonArray, String stringValue) {
        ArrayList<String> stringValueList = new ArrayList<String>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            JSONArray fieldList = obj.getJSONArray("fieldList");
            int valuePoint = getValuePoint(fieldList, stringValue);
            if (valuePoint >= 0) {
                JSONObject childObj = fieldList.getJSONObject(valuePoint);
                String fieldValue = childObj.getString("fieldValue");
                stringValueList.add(fieldValue);
            } else {
                stringValueList.add("");
            }
        }
        return stringValueList;
    }

    // 获取返回结果中的所有iD
    public List<String> getIdList(JSONArray jsonArray) {
        List<String> idList = new ArrayList<String>();
        for (Object obj : jsonArray) {
            JSONObject item = (JSONObject) obj;
            idList.add(item.getString("iD"));
        }
        return idList;
    }

    /**
     * 根据stringValue获取返回JSONArray(fieldList)结果中对应字段的位置
     *
     * @param jsonarray
     * @param stringValue
     * @return
     */
    public int getValuePoint(JSONArray jsonarray, String stringValue) {
        int valuePoint = 0;
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject child = jsonarray.getJSONObject(i);
            String fieldName = child.getString("fieldName");
            if (fieldName.equals(stringValue)) {
                valuePoint = i;
                break;
            } else {
                valuePoint = -1;
                continue;
            }
        }
        return valuePoint;
    }



    /**
     * 将多个字段的fieldValue已经对应的id组装进valueMapList
     * 用于需要验证多个个返回字段的方法
     * @param jsonArray
     * @param stringValueList
     * @return
     */
    public ArrayList<Map> getMultipleFieldsList(JSONArray jsonArray, List<String> stringValueList) {
        ArrayList<Map> valueMapList = new ArrayList<Map>();
        for (int i = 0; i < jsonArray.size(); i++) {
            //遍历activityInfoList下的节点内容obj（JSONObject）对象
            JSONObject obj = (JSONObject) jsonArray.get(i);
            //初始化valueMap用来组装数据
            Map<String, String> valuesMap = new HashMap<String, String>();
            //获取每个obj节点中的iD值
            String iD = obj.getString("iD");
            //将id值放进valueMap
            valuesMap.put("iD", iD);

            //获取obj节点中fieldList（JSONArray）
            JSONArray fieldList = obj.getJSONArray("fieldList");

            //遍历传入的stringValueList,用来获得对应fieldName的fieldValue值
            for (int j = 0; j <stringValueList.size() ; j++) {
                //获得对应fieldName在fieldList中的位置
                int valuePoint = getValuePoint(fieldList, stringValueList.get(j));
                if (valuePoint >= 0){
                    //获得fieldList每个子节点下的childObj(JSONObject)对象
                    JSONObject childObj = fieldList.getJSONObject(valuePoint);
                    //获得对应fieldName在fieldList中的fieldValue值
                    String fieldValue = childObj.getString("fieldValue");
                    ////将fieldValue值放进valueMap
                    valuesMap.put("fieldValue", fieldValue);
                }else {
                    valuesMap.put("fieldValue", null);
                }
            }
            valueMapList.add(valuesMap);
        }
        return valueMapList;
    }

    /**
     * 将单个字段的fieldValue以及对应的id组装进valueMapList
     * 用于只验证一个返回字段的方法
     * @param jsonArray
     * @param stringValue
     * @return
     */
    public ArrayList<Map> getSingleFieldList(JSONArray jsonArray, String stringValue) {
        ArrayList<Map> valueMapList = new ArrayList<Map>();
        for (int i = 0; i < jsonArray.size(); i++) {

            //遍历activityInfoList下的节点内容obj（JSONObject）对象
            JSONObject obj = (JSONObject) jsonArray.get(i);
            //初始化valueMap用来组装数据
            Map<String, String> valueMap = new HashMap<String, String>();
            //获取每个obj节点中的iD值
            String iD = obj.getString("iD");
            //将id值放进valueMap
            valueMap.put("iD", iD);

            //获取obj节点中fieldList（JSONArray）
            JSONArray fieldList = obj.getJSONArray("fieldList");
            //获得对应fieldName在fieldList中的位置
            int valuePoint = getValuePoint(fieldList, stringValue);
            if (valuePoint >= 0) {
                //获得fieldList每个子节点下的childObj(JSONObject)对象
                JSONObject childObj = fieldList.getJSONObject(valuePoint);
                //获得对应fieldName在fieldList中的fieldValue值
                String fieldValue = childObj.getString("fieldValue");
                ////将fieldValue值放进valueMap
                valueMap.put("fieldValue", fieldValue);
            } else {
                valueMap.put("fieldValue", null);
            }
            valueMapList.add(valueMap);
        }
        return valueMapList;
    }



}
