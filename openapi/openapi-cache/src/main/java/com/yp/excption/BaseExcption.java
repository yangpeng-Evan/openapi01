package com.yp.excption;

import lombok.Data;

/**
 * @author yangpeng
 */
@Data
public class BaseExcption extends RuntimeException {

    //错误码
    private String code;
    //错误信息
    private String msg;

    public BaseExcption(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
