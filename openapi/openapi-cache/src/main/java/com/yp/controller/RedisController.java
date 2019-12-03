package com.yp.controller;

import com.yp.service.RedisServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangpeng
 */
@RestController
@RequestMapping("/cache")
public class RedisController {

    @Autowired
    private RedisServiceApi redisServiceApi;
    @GetMapping("/save")
    public boolean save(String key,String value,Long expire){
        System.out.println("ceshi");
        return redisServiceApi.set(key, value, expire);

    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key){
        return redisServiceApi.get(key);
    }

    @GetMapping("/delete/{key}")
    public boolean delete(@PathVariable String key){
        return redisServiceApi.delete(key);
    }
}
