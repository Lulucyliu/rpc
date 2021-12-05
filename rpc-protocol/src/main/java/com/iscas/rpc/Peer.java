package com.iscas.rpc;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 21:52 2021-12-02
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program rpc
 * @description: 表示网络传输的一个端点
 * @author: apple
 * @create: 2021/12/02 21:52 
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
