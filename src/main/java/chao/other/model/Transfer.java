package chao.other.model;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zl on 2019/3/21.
 */
public class Transfer {

    public static String get(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = client.execute(get);
        HttpEntity respEntity = resp.getEntity();
        String result = EntityUtils.toString(respEntity,"UTF-8");
        client.close();
        return result;
    }


    public static String post(String url,String collection) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(collection, "utf-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        post.setEntity(stringEntity);
        CloseableHttpResponse resp = client.execute(post);
        HttpEntity respEntity = resp.getEntity();
        String result = EntityUtils.toString(respEntity,"UTF-8");
        client.close();
        return result;
    }

    public static String put(String url,String collection) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPut put = new HttpPut(url);
        StringEntity stringEntity = new StringEntity(collection, "utf-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        put.setEntity(stringEntity);
        CloseableHttpResponse resp = client.execute(put);
        HttpEntity respEntity = resp.getEntity();
        String result = EntityUtils.toString(respEntity,"UTF-8");
        client.close();
        return result;
    }

    public static String delete(String url) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpDelete delete = new HttpDelete(url);
        CloseableHttpResponse resp = client.execute(delete);
        HttpEntity respEntity = resp.getEntity();
        String result = EntityUtils.toString(respEntity,"UTF-8");
        client.close();
        return result;
    }
}
