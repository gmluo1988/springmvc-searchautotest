package cn.gmluo.searchapitest.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.MapUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.HttpMethod;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * HttpClient请求接口封装
 * Created by gmluo on 2018/5/10.
 */
public class HttpClientUtil {
    /**
     * 请求报文格式为Map<String,String>类型
     *
     * @param method
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws IOException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static HttpResponse execute(HttpMethod method, String url, Map<String, String> params, Map<String, String> headers) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        HttpClient client = null;
        HttpRequestBase requestBase = null;
        HttpResponse response = null;
        if (method == HttpMethod.GET) {
            requestBase = new HttpGet(url);
        } else if (method == HttpMethod.POST) {
            requestBase = new HttpPost(url);
        } else if (method == HttpMethod.PUT) {
            requestBase = new HttpPut(url);
        } else if (method == HttpMethod.DELETE) {
            requestBase = new HttpDelete(url);
        } else {
            return null;
        }
        //设置参数
        if (params != null) {
            JSONObject jsonParam = new JSONObject();
            if (MapUtils.isNotEmpty(params)) {
                Set<Map.Entry<String, String>> set = params.entrySet();
                for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
                    Map.Entry<String, String> param = it.next();
                    if (param != null) {
                        jsonParam.put(param.getKey(), param.getValue());
                    }
                }
            }
            StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");//解决中文乱码问题
            entity.setContentEncoding("UTF-8");
            entity.setContentType("application/json");
            ((HttpEntityEnclosingRequestBase) requestBase).setEntity(entity);
        }

        //setHeader
        if (MapUtils.isNotEmpty(headers)) {
            Set<Map.Entry<String, String>> set = headers.entrySet();
            for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
                Map.Entry<String, String> header = it.next();
                if (header != null) {
                    requestBase.setHeader(header.getKey(), header.getValue());
                }
            }
        }
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier());
        client = httpClientBuilder.build();
        response = client.execute(requestBase);
        return response;
    }

    /**
     * 请求报文格式为json
     *
     * @param method
     * @param url
     * @param params
     * @param headers
     * @return
     * @throws IOException
     * @throws KeyStoreException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static HttpResponse executeWithJson(HttpMethod method, String url, String params, Map<String, String> headers) throws IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        HttpClient client = null;
        HttpRequestBase requestBase = null;
        HttpResponse response = null;
        if (method == HttpMethod.GET) {
            requestBase = new HttpGet(url);
        } else if (method == HttpMethod.POST) {
            requestBase = new HttpPost(url);
        } else if (method == HttpMethod.PUT) {
            requestBase = new HttpPut(url);
        } else {
            return null;
        }
        //设置参数
        if (params != null) {
            StringEntity requestEntity = new StringEntity(params, ContentType.APPLICATION_JSON);
            ((HttpEntityEnclosingRequestBase) requestBase).setEntity(requestEntity);
        }
        //setHeader
        if (MapUtils.isNotEmpty(headers)) {
            Set<Map.Entry<String, String>> set = headers.entrySet();
            for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext(); ) {
                Map.Entry<String, String> header = it.next();
                if (header != null) {
                    requestBase.setHeader(header.getKey(), header.getValue());
                }
            }
        }
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        }).build();
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier());
        client = httpClientBuilder.build();
        response = client.execute(requestBase);
        return response;
    }

}
