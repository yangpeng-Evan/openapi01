package com.yp.excption;

import lombok.Data;

/**
 * @author yangpeng
 */
public class RedisExcption extends BaseExcption {

    public RedisExcption(String code, String msg) {
        super(code, msg);
    }
}
