package com.iscas.rpc.transport;

/**
 * @Author: Liulu
 * @Description:
 * 1、启动，监听端口
 * 2、接收请求
 * 3、关闭监听
 * @Date: Create in 15:19 2021-12-04
 */
public interface TransportServer {
    /**
     * 启动jetty
     * @param port 端口
     * @param handler 请求处理器
     */
    void init(int port,RequestHandler handler);

    /**
     * 开始等待连接
     */
    void start();

    /**
     * 关闭jetty
     */
    void stop();
}
