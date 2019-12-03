package com.yp.service;

/**
 * @author yangpeng
 */
public interface RedisServiceApi {
    /**
     * 往redis中存数据
     * @param key
     * @param value
     * @param expire
     * @return
     */
    boolean set(String key,String value,Long expire);

    boolean expire(String key,Long expire);

    /**
     * 根据key获取value的值
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 删除指定的key值
     * @param key
     * @return
     */
    boolean delete(String key);
}
