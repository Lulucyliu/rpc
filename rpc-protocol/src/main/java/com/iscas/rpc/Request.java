package com.iscas.rpc;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 21:57 2021-12-02
 */

import lombok.Data;

/**
 * @program rpc
 * @description: 表示rpc的一个请求
 * @author: apple
 * @create: 2021/12/02 21:57 
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
