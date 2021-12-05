package com.iscas.rpc.codec;

/**
 * @Author: Liulu
 * @Description: 序列化
 * @Date: Create in 11:12 2021-12-04
 */
public interface Encoder {

    byte[] encode(Object object);
}
