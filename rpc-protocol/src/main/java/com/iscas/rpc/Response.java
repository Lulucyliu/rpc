package com.iscas.rpc;/**
 * @Author: Liulu
 * @Description:
 * @Date: Create in 21:58 2021-12-02
 */

import lombok.Data;

/**
 * @program rpc
 * @description: 表示响应的一个类
 * @author: apple
 * @create: 2021/12/02 21:58 
 */
@Data
public class Response {
    /**
     * 服务返回编码：0-成功，非0失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "success";
    /**
     * 返回的数据
     */
    private Object data;

}
