package com.iscas.rpc.client;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 10:33 2021-12-05
 */

import com.iscas.rpc.Peer;
import com.iscas.rpc.codec.Decoder;
import com.iscas.rpc.codec.Encoder;
import com.iscas.rpc.codec.JSONDecoder;
import com.iscas.rpc.codec.JSONEncoder;
import com.iscas.rpc.transport.HTTPTransportClient;
import com.iscas.rpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/05 10:33 
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1",3000));
}
