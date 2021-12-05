package com.iscas.rpc.server;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:58 2021-12-04
 */

import com.iscas.rpc.Request;
import com.iscas.rpc.Response;
import com.iscas.rpc.codec.Decoder;
import com.iscas.rpc.codec.Encoder;
import com.iscas.rpc.common.utils.ReflectionUtils;
import com.iscas.rpc.transport.RequestHandler;
import com.iscas.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/04 16:58 
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoke serviceInvoke;

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        //net网络模块
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);

        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        //serivce
        this.serviceManager = new ServiceManager();
        this.serviceInvoke = new ServiceInvoke();

    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decode(inBytes, Request.class);

                log.debug("get request: {}", request);
                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoke.invoke(sis, request);

                response.setData(ret);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error: " + e.getClass().getName() + ":" + e.getMessage());
            } finally {
                byte[] outBytes = encoder.encode(response);
                try {
                    toResp.write(outBytes);
                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };

}
