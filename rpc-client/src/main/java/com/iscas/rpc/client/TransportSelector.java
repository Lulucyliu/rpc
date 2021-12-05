package com.iscas.rpc.client;

import com.iscas.rpc.Peer;
import com.iscas.rpc.transport.TransportClient;

import java.util.List;

/**
 * @Author: Liulu
 * @Description: 表示选择哪个server去连接
 * @Date: Create in 10:15 2021-12-05
 */
public interface TransportSelector {

    /**
     * 初始化selector信息
     * @param peers 可以连接的Server端点信息
     * @param count client与server建立多少个连接
     * @param clazz client实现class
     */
    void init(List<Peer> peers,int count,Class<? extends TransportClient> clazz);

    /**
     * 选择一个transport与server做交互
     *
     * @return 网络client
     */
    TransportClient select();

    /**
     * 释放用完的client
     *
     * @param client
     */
    void release(TransportClient client);

    /**
     * 把整个selector关掉
     */
    void close();
}