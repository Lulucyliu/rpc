package com.iscas.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: Liulu
 * @Description: 处理网络请求的handler
 * @Date: Create in 15:29 2021-12-04
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}
