package com.iscas.rpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:35 2021-12-04
 */
public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder =new JSONEncoder();
        TestBean testBean = new TestBean();
        testBean.setName("iscas");
        testBean.setAge(18);
        byte[] bytes = encoder.encode(testBean);

        Decoder decoder = new JSONDecoder();

        TestBean testBean2 = decoder.decode(bytes,TestBean.class);

        assertEquals(testBean.getName(),testBean2.getName());
        assertEquals(testBean.getAge(),testBean2.getAge());
    }
}