package com.cloud.base.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * 模拟https 请求
 */
public class HttpsClient {
    private static Logger LOGGER = LoggerFactory.getLogger(HttpsClient.class);

    public static String doPost(String url, Map<String, Object> params, String charset) {
        String result = "";
        PoolingHttpClientConnectionManager connectionManager = null;
        try {
            SSLContext sslContext;
            sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                @Override
                public boolean isTrusted(X509Certificate[] chain, String authType)
                        throws CertificateException {
                    return true;
                }

            }).build();
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1.2"}, null, new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();
            connectionManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

            CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
            HttpPost httpPost;
            httpPost = new HttpPost(url);
            httpPost.addHeader("Content-Type", "text/plain");
            JSONObject jsonObject = new JSONObject(params);
            StringEntity se = new StringEntity(jsonObject.toString(), charset);
            se.setContentType("text/plain");
            se.setContentEncoding(new BasicHeader("Content-Type", "text/plain"));
            httpPost.setEntity(se);
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception e) {
            LOGGER.debug("https请求异常:{}", e);
        } finally {
            if (connectionManager != null) {
                connectionManager.close();
            }
        }
        return result;
    }


//    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
////        String url="bluetoothInfoAdd.php";
//        String base="https://zhsq.zhihushequ.com/bluetooth/";
//        String url="bluetoothSendOrder.php";
//        Map<String,Object> params=new HashMap<>();
//        params.put("account","yyjk");
//        params.put("password","888666");
//        params.put("deviceId","169E197C");
//        params.put("devicePw","87654321");
////        JSONObject jsonObject=new JSONObject(params);
////        String json=jsonObject.toJSONString();
//        String body=doPost(base+url,params,"UTF-8");
//        System.out.println(body);
//    }
}
