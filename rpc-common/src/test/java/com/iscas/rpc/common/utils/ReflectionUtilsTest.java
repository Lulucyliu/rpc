package com.iscas.rpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 09:22 2021-12-03
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);

        String methodName = methods[0].getName();
        assertEquals("b",methodName);
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];
        TestClass t = new TestClass();
        Object r = ReflectionUtils.invoke(t,b);
        assertEquals("b",r);
    }
}