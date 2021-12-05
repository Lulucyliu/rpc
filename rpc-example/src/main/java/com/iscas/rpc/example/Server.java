package com.iscas.rpc.example;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:11 2021-12-05
 */

import com.iscas.rpc.server.RpcServer;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/05 11:11 
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalService.class,new CalcServiceImpl());
        server.start();
    }
}
