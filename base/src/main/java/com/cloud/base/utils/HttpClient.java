package com.cloud.base.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClient.class);
    public static String doGet(String url,Map<String,String> params) throws IOException {
        String body="";
        String path=url;
        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        try {
            client = HttpClients.createDefault();
            if(params!=null&&params.size()>0){
                List<NameValuePair> paramsList = new ArrayList<>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    paramsList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                String paramsStr = EntityUtils.toString(new UrlEncodedFormEntity(paramsList, Consts.UTF_8));
                path=url+"?"+paramsStr;
            }
            HttpGet httpGet=new HttpGet(path);
            response = client.execute(httpGet);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, Consts.UTF_8);
            }
            EntityUtils.consume(entity);
        } catch (IOException e) {
            LOGGER.warn("IOException{}", e.getMessage(), e);
        } catch (ParseException e) {
            LOGGER.warn("ParseException{}", e.getMessage(), e);
        } finally {
            if (client != null) {
                client.close();
            }
            //释放链接
            if(response != null){
                response.close();
            }

        }
        return body;
    }

    public static String doPost(String url,Map<String,Object> params,String encoding) throws IOException {
        String body = "";
        String contentType="text/plain";
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            //创建httpclient对象
            client = HttpClients.createDefault();
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            //设置header信息
            //指定报文头【Content-type】、【User-Agent】
            httpPost.setHeader("Content-type", contentType);
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            JSONObject jsonObject=new JSONObject(params);
            //设置参数到请求对象中
            StringEntity requestEntity = new StringEntity(jsonObject.toString(), Consts.UTF_8);

            httpPost.setEntity(requestEntity);

            //执行请求操作，并拿到结果（同步阻塞）
            response = client.execute(httpPost);
            //获取结果实体
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                //按指定编码转换结果实体为String类型
                body = EntityUtils.toString(entity, encoding);
            }
            EntityUtils.consume(entity);
        } catch (UnsupportedCharsetException e) {
            LOGGER.warn("UnsupportedCharsetException：{}", e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.warn("IOException：{}", e.getMessage(), e);
        } catch (ParseException e) {
            LOGGER.warn("ParseException：{}", e.getMessage(), e);
        } finally {
            //释放链接
            if(client != null){
                client.close();
            }
            if(response != null){
                response.close();
            }
        }
        return body;
    }
}
