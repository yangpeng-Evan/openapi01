package com.yp.service;

import com.sun.javafx.collections.MappingChange;

import java.util.Map;
import java.util.Set;

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

    /**
     * 设置生存时间
     * @param key
     * @param expire
     * @return
     */
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

    /**
     * 根据key获取值
     * @param key
     * @return
     */
    Map<Object,Object> hGetAll(String key);

    /**
     * 从redis中获取指定的key的field值
     * @param key
     * @param field
     * @return
     */
    String hget(String key,String field);

    /**
     * 获取指定的set
     * @param key
     * @return
     */
    Set<String> getSet(String key);

    /**
     * hash中自增或者自减
     * @param key
     * @param field
     * @param increment
     * @return
     */
    long hdecr(String key,String field,long increment);

    /**
     * 查询指定结构的key
     * @param partten
     * @return
     */
    Set<String> keys(String partten);

    /**
     * 想redis中指定key批量设置hash值
     * @param key
     * @param fieldValue
     */
    void mput(String key,Map fieldValue);
}
