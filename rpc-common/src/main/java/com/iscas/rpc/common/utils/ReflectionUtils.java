package com.iscas.rpc.common.utils;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 22:03 2021-12-02
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @program rpc
 * @description: 反射工具类
 * @author: apple
 * @create: 2021/12/02 22:03 
 */
public class ReflectionUtils {
    /**
     * 根据class创建对象
     * @param clazz 待创建对象的类
     * @param <T> 对象类型
     * @return 创建好的对象实例
     */
    public static <T> T newInstance(Class<T> clazz) {

        try {
            return clazz.newInstance();//调用默认的无参构造方法
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    /**
     * 获取某个class的所有公共方法
     * @param clazz
     * @return 当前类的公共方法
     */
    public static Method[] getPublicMethods(Class clazz){

        Method[] methods =clazz.getDeclaredMethods();//返回当前类所有方法，不包括父类
        //过滤public类
        List<Method> pmethods= new ArrayList<>();
        for(Method method:methods){
            //判断方法的修饰符是否为public
            if(Modifier.isPublic(method.getModifiers())){
                pmethods.add(method);
            }
        }
        /**
         * toArray() 和 toArray(T[])的区别
         * 1、前者返回Oeject[],后者根据类型参数指定返回类型数组
         * eg:toArray(T[]),方法会T[]数组size，来判断是否生成更大size的新[],参见源码
         */
        return pmethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     *
     * @param obj 调用方法的所属对象
     * @param method 调用的方法
     * @param args 方法的参数 (...表示为可变长参数，可传入0到n个参数，用逗号隔开，同时也可以传入一个数组)
     * @return 返回结果
     */
    public static Object invoke(Object obj,Method method,Object... args){
        try {
            return method.invoke(obj,args);//调用对象的方法，并传入方法参数args
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }
}
