package com.iscas.rpc.codec;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:29 2021-12-04
 */

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @program rpc
 * @description: 基于JSON的反序列化实现
 * @author: apple
 * @create: 2021/12/04 11:29 
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            t = objectMapper.readValue(bytes,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return t;
    }
}
