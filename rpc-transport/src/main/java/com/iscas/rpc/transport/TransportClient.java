package com.iscas.rpc.transport;

import com.iscas.rpc.Peer;

import java.io.InputStream;

/**
 * @Author: Liulu
 * @Description:
 * 1、创建连接
 * 2、发送数据，并且等待响应
 * 3、关闭连接
 * @Date: Create in 11:41 2021-12-04
 */
public interface TransportClient {

    /**
     * 创建连接
     * @param peer 服务端节点
     */
    void connect(Peer peer);

    /**
     * 像流中写入数据
     * @param data TODO 数据流
     * @return 响应数据流
     */
    InputStream write(InputStream data);

    /**
     * 关闭连接
     */
    void close();
}

