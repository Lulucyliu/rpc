package com.iscas.rpc.server;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:29 2021-12-04
 */

import com.iscas.rpc.Request;
import com.iscas.rpc.ServiceDescriptor;
import com.iscas.rpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program rpc
 * @description: 管理rpc暴露的服务
 * @author: apple
 * @create: 2021/12/04 16:29 
 */
@Slf4j
public class ServiceManager {

    private Map<ServiceDescriptor,ServiceInstance> services;
    //查找服务
    public ServiceManager(){
        this.services=new ConcurrentHashMap<>();
    }

    //注册服务
    public <T> void register(Class<T> interfaceClass,T bean){
        Method[] methods =ReflectionUtils.getPublicMethods(interfaceClass);

        for(Method method:methods){
            ServiceInstance sis = new ServiceInstance(bean,method);
            ServiceDescriptor sdp = ServiceDescriptor.form(interfaceClass,method);

            services.put(sdp,sis);
            log.info("register service:{} {}",sdp.getClazz(),sdp.getMethod());
        }
    }


    public ServiceInstance lookup(Request request){
        ServiceDescriptor sdp = request.getService();
        return services.get(sdp);
    }
}
