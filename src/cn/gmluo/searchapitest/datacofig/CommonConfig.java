package cn.gmluo.searchapitest.datacofig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gmluo on 2018/5/10.
 */
public class CommonConfig {
    /**
     * 1.设置搜索接口请求地址RequestUrl
     */
    //UAT环境
//    private String activityUrl = "http://10.5.94.193:8080/api/bjjson/activitySearch";
//    private String scenicUrl = "http://10.5.71.50:8080/api/bjjson/scenicSpotSearch";

    //人工干预相关测试url配置
    //Pro环境
    private String activityUrl = "http://10.28.138.58:8080/api/json/activitySearch";//玩乐ES搜索
    private String scenicUrl = "http://10.28.180.46:8080/api/json/scenicSpotSearch";//门票ES搜索

    //人工干预信息配置请求url-pro
    private String interventionUrl="http://10.28.180.46:8080/restful/cache/adtopconfig";


    //2.设置请求header
    private Map<String,String> headers=new HashMap<String, String>();

    public Map<String, String> getHeaders() {
        Map<String,String> headers=new HashMap<String, String>();
        headers.put("Content-Type","application/json");
        headers.put("SOA20-Client-AppId","100001521");
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    public String getScenicUrl() {
        return scenicUrl;
    }

    public void setScenicUrl(String scenicUrl) {
        this.scenicUrl = scenicUrl;
    }

    public String getInterventionUrl() {
        return interventionUrl;
    }

    public void setInterventionUrl(String interventionUrl) {
        this.interventionUrl = interventionUrl;
    }
}