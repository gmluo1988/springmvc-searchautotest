package cn.gmluo.searchapitest.getresponse.requesttype.intervention;

import java.util.List;

/**
 * 人工干预校验执行请求参数"apiTypeList": [1,2,3]
 * 1:门票列表页;2:玩乐混排列表页;3:一日游列表页
 * Created by gmluo on 2018/5/11.
 */
public class ExecuteIdList {
    private List<Integer> apiTypeList;

    public List<Integer> getApiTypeList() {
        return apiTypeList;
    }

    public void setApiTypeList(List<Integer> apiTypeList) {
        this.apiTypeList = apiTypeList;
    }
}
