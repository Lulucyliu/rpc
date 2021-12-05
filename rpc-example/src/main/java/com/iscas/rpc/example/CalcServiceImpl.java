package com.iscas.rpc.example;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:11 2021-12-05
 */

/**
 * @program rpc
 * @description:
 * @author: apple
 * @create: 2021/12/05 11:11 
 */
public class CalcServiceImpl implements CalService{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int minus(int a, int b) {
        return a-b;
    }
}
