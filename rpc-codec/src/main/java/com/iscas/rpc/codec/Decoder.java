package com.iscas.rpc.codec;

/**
 * @Author: Liulu
 * @Description: εεΊεε
 * @Date: Create in 11:12 2021-12-04
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
