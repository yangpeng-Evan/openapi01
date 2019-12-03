package com.yp.service.impl;

import com.yp.service.RedisServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yangpeng
 */
@Service
public class RedisServiceApiImpl implements RedisServiceApi {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean set(String key, String value, Long expire) {
        redisTemplate.opsForValue().set(key,value);
        return expire(key, expire);
    }

    @Override
    public boolean expire(String key, Long expire) {
        return redisTemplate.expire(key,expire, TimeUnit.MILLISECONDS);
    }

    @Override
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }
}
