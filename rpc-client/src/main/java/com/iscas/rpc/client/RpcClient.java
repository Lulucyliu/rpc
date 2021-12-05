package com.iscas.rpc.client;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 10:39 2021-12-05
 */

import com.iscas.rpc.codec.Decoder;
import com.iscas.rpc.codec.Encoder;
import com.iscas.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/05 10:39 
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());

        this.selector.init(this.config.getServers(),this.config.getConnectCount(),this.config.getTransportClass());
    }

    /**
     * 获取接口的代理对象
     * 利用Java的反射技术(Java Reflection)，在运行时创建一个实现某些给定接口的新类（也称“动态代理类”）及其实例（对象）,
     * 代理的是接口(Interfaces)，不是类(Class)，也不是抽象类。在运行时才知道具体的实现
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getProxy(Class<T> clazz){
        /**
         * newProxyInstance，方法有三个参数：
         *
         * loader: 用哪个类加载器去加载代理对象
         *
         * interfaces:动态代理类需要实现的接口
         *
         * h:动态代理方法在执行时，会调用h里面的invoke方法去执行
         */
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(),new Class[]{clazz},new RemoteInvoker(clazz,encoder,decoder,selector));
    }

}
