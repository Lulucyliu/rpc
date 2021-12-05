package com.iscas.rpc.transport;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 15:35 2021-12-04
 */

import com.iscas.rpc.Peer;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.HttpConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/04 15:35 
 */
public class HTTPTransportClient implements TransportClient{
    private String url;

    @Override
    public void connect(Peer peer) {
        // 因为在此使用的是TCP短连接（想要使用长连接可以考虑套接字）
        // 所以connect方法只是象征性初始化url数据，没有进行网络请求
        this.url = "http://"+peer.getHost()+":"+peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        // 在write方法中，我们进行了网络请求
        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.setUseCaches(false);
            httpConn.setRequestMethod("POST");

            httpConn.connect();

            IOUtils.copy(data,httpConn.getOutputStream());

            int resultCode = httpConn.getResponseCode();

            if(resultCode == HttpURLConnection.HTTP_OK){
                return httpConn.getInputStream();
            }else{
                return httpConn.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void close() {
        // 同connect方法，close方法只是进行了一次模拟
    }
}
