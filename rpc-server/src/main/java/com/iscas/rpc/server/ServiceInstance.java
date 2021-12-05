package com.iscas.rpc.server;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:27 2021-12-04
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @program rpc
 * @description: 表示一个具体服务
 * @author: apple
 * @create: 2021/12/04 16:27 
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    //服务由哪个对象提供
    private Object target;
    //这个对象的哪个方法暴露为一个服务
    private Method method;
}
