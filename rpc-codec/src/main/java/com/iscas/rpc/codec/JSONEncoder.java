package com.iscas.rpc.codec;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:14 2021-12-04
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @program rpc
 * @description: 基于Json的序列化实现
 * @author: apple
 * @create: 2021/12/04 11:14
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = new byte[0];
        try {
            bytes = objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
