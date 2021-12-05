package com.iscas.rpc.server;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:20 2021-12-04
 */

import com.iscas.rpc.codec.Decoder;
import com.iscas.rpc.codec.Encoder;
import com.iscas.rpc.codec.JSONDecoder;
import com.iscas.rpc.codec.JSONEncoder;
import com.iscas.rpc.transport.HTTPTransportServer;
import com.iscas.rpc.transport.TransportServer;
import lombok.Data;

/**
 * @program rpc
 * @description: server配置
 * @author: apple
 * @create: 2021/12/04 16:20 
 */
@Data
public class RpcServerConfig {

    //代表使用那个网络模块
    //使用那个序列化是实现
    //server监听端口

    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;



}
