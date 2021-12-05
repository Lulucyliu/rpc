package com.iscas.rpc.server;

import com.iscas.rpc.Request;
import com.iscas.rpc.ServiceDescriptor;
import com.iscas.rpc.common.utils.ReflectionUtils;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 16:49 2021-12-04
 */
public class ServiceManagerTest {

    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.form(TestInterface.class,method);

        Request request = new Request();
        request.setService(sdp);
        ServiceInstance sis = sm.lookup(request);
        assertNotNull(sis);
    }
}