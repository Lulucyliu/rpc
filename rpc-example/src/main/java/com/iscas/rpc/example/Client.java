package com.iscas.rpc.example;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:11 2021-12-05
 */

import com.iscas.rpc.client.RpcClient;

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/05 11:11 
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalService service = client.getProxy(CalService.class);
        int r1 = service.add(1,1);
        int r2 = service.minus(10,2);

        System.out.println(r1);
        System.out.println(r2);
    }
}
