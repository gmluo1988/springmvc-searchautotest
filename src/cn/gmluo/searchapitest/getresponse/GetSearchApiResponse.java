package cn.gmluo.searchapitest.getresponse;


import cn.gmluo.searchapitest.datacofig.CommonConfig;
import cn.gmluo.searchapitest.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;


import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * 获取搜索接口返回数据封装方法
 * Created by gmluo on 2018/3/22.
 */
public class GetSearchApiResponse {
    private CommonConfig commonConfig = new CommonConfig();
    Map<String, String> headers = commonConfig.getHeaders();

    /**
     * 获取玩乐接口返回数据方法(JSONObject：json格式)
     */
    public JSONObject getActivityJSONResponse(String source) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String url = commonConfig.getActivityUrl();
        return getResponse(HttpMethod.POST,url, source, headers);
    }

    /**
     * 获取玩乐接口返回数据下activityInfoList节点数据方法(JSONArray格式)
     */
    public JSONArray getActivityJSONArrayResponse(String source) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String url = commonConfig.getActivityUrl();
        return getResponse(HttpMethod.POST,url, source, headers).getJSONArray("activityInfoList");
    }


    /**
     * 获取门票接口返回数据方法(json格式)
     */
    public JSONObject getScenicResponse(String source) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String url = commonConfig.getScenicUrl();
        return getResponse(HttpMethod.POST,url, source, headers);
    }

    /**
     * 获取门票接口返回数据下scenicSpotList节点数据方法(JSONArray格式)
     */
    public JSONArray getScenicJSONArrayResponse(String source) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        String url = commonConfig.getScenicUrl();
        return getResponse(HttpMethod.POST,url, source, headers).getJSONArray("scenicSpotList");
    }



    /**
     * 获取人工干预返回报文中的配置信息
     * apiType(1:门票列表页;2:混排列表页;3:一日游列表页)
     * @param apiType
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    public JSONObject getInterventionInfo(int apiType) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String url=commonConfig.getInterventionUrl();
        JSONObject jsonObject=getResponse(HttpMethod.GET,url,null,headers);
        JSONObject interventionInfo=new JSONObject();
        switch (apiType){
            case 1:
                interventionInfo=jsonObject.getJSONObject("门票列表页");
                break;
            case 2:
                interventionInfo=jsonObject.getJSONObject("混排列表页");
                break;
            case 3:
                interventionInfo=jsonObject.getJSONObject("一日游列表页");
                break;
            default:
                break;
        }
        return interventionInfo;
    }


    /**
     * 获取API接口返回信息
     * 并将（HttpResponse）返回信息处理成JSONObject格式统一方法
     *
     * @param url
     * @param source
     * @param headers
     */
    public JSONObject getResponse(HttpMethod method,String url, String source, Map<String, String> headers) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        //1.获取返回报文
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        HttpResponse response = httpClientUtil.executeWithJson(method, url, source, headers);
        //2.处理返回报文信息
        String msg = EntityUtils.toString(response.getEntity());
        //3.将返回信息进行序列化，处理成json格式
        JSONObject jsonSource = JSON.parseObject(msg);
        return jsonSource;
    }



    //最初的方法（2018/3/22）
//    public JSONObject getResponse( String source) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
//        CommonConfig commonConfig=new CommonConfig();
//        //1.设置请求url
//        String url=commonConfig.getScenicUrl();
//
//        //2.设置请求header
//        Map<String,String> headers=commonConfig.getHeaders();
//
//        //3.获取返回报文
//        HttpClientUtil httpClientUtil=new HttpClientUtil();
//        HttpResponse response= httpClientUtil.executeWithJson(HttpMethod.POST,url,source,headers);
//
//        //5.处理返回报文信息
//        String msg = EntityUtils.toString(response.getEntity());
//        //6.将返回信息进行序列化，处理成json格式
//        JSONObject jsonSource = JSON.parseObject(msg);
//
//        return jsonSource;
//    }

}
