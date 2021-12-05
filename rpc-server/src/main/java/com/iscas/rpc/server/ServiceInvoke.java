package com.iscas.rpc.server;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:57 2021-12-04
 */

import com.iscas.rpc.Request;
import com.iscas.rpc.common.utils.ReflectionUtils;

/**
 * @program rpc
 * @description: 调用具体服务
 * @author: apple
 * @create: 2021/12/04 16:57 
 */
public class ServiceInvoke {
    public Object invoke(ServiceInstance service,
                         Request request){
        return ReflectionUtils.invoke(service.getTarget(),service.getMethod(),request.getParameters());

    }
}
