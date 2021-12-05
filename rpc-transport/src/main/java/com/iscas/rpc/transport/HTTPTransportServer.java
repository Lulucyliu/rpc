package com.iscas.rpc.transport;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 15:59 2021-12-04
 */

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/04 15:59 
 */
@Slf4j
public class HTTPTransportServer implements TransportServer {

    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        //挂在handler和服务器
        this.handler=handler;
        this.server = new Server(port);

        //servlet 接收请求
        ServletContextHandler ctx = new ServletContextHandler();
        server.setHandler(ctx);

        //jetty处理网络请求的一个抽象
        ServletHolder holder = new ServletHolder(new RequestServlet());
        ctx.addServlet(holder,"/*");

    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }


    /**
     * 内部类
     */
    class RequestServlet extends HttpServlet{
        /**
         * 重写了doPost方法，因为client使用post来进行请求
         */
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");

            InputStream input = req.getInputStream();
            OutputStream output = resp.getOutputStream();

            if(handler!=null){
                handler.onRequest(input,output);
            }

            output.flush();
        }
    }
}
