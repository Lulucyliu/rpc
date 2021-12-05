package com.iscas.rpc.codec;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 11:32 2021-12-04
 */
public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder =new JSONEncoder();
        TestBean testBean = new TestBean();
        testBean.setName("iscas");
        testBean.setAge(18);
        byte[] bytes = encoder.encode(testBean);

        assertNotNull(bytes);
    }
}