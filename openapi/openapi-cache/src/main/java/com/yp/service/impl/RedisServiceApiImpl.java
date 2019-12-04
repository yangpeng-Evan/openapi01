package com.yp.service.impl;

import com.yp.service.RedisServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;
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

    @Override
    public Map<Object, Object> hGetAll(String key) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    @Override
    public String hget(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key,field);
    }

    @Override
    public Set<String> getSet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    @Override
    public long hdecr(String key, String field, long increment) {
        return redisTemplate.opsForHash().increment(key,field,increment);
    }

    @Override
    public Set<String> keys(String partten) {
        return redisTemplate.keys(partten);
    }

    @Override
    public void mput(String key, Map fieldValue) {
        redisTemplate.opsForHash().putAll(key,fieldValue);
    }
}
