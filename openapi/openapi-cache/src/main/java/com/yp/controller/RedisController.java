package com.yp.controller;

import com.yp.excption.ExcptionDict;
import com.yp.excption.RedisExcption;
import com.yp.service.RedisServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.Set;

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
        checkKey(key);
        return redisServiceApi.set(key, value, expire);

    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key){
        checkKey(key);
        return redisServiceApi.get(key);
    }

    @GetMapping("/delete/{key}")
    public boolean delete(@PathVariable String key){
        checkKey(key);
        return redisServiceApi.delete(key);
    }

    @GetMapping("/hgetall/{key}")
    public Map<Object,Object> hgetall(@PathVariable("key") String key){
        checkKey(key);
        return redisServiceApi.hGetAll(key);
    }

    @GetMapping("/hget/{key}/{field}")
    public String hget(@PathVariable("key") String key,@PathVariable("field") String field){
        checkKey(key);
        checkKey(field);
        return redisServiceApi.hget(key, field);
    }

    @GetMapping("/members/{key}")
    public Set<String> members(@PathVariable String key){
        checkKey(key);
        return redisServiceApi.getSet(key);
    }

    @GetMapping("/hdecr/{key}/{field}")
    public long hdecr(@PathVariable String key, @PathVariable String field, @RequestParam(defaultValue = "0") long increment){
        increment = increment == 0 ? -1 : increment;
        return redisServiceApi.hdecr(key, field, increment);
    }

    @GetMapping("/keys/{partten}")
    public Set<String> keys(@PathVariable String partten){
        return redisServiceApi.keys(partten);
    }

    @GetMapping("/mput/{key}")
    public boolean mput(@PathVariable String key,@RequestBody Map fieldValue){
        checkKey(key);
        redisServiceApi.mput(key,fieldValue);
        return true;
    }



    //校验传入的参数key
    private void checkKey(String key){
        if (key == null || "".equalsIgnoreCase(key)){
            throw new RedisExcption(ExcptionDict.REDISKEYISNULL,"redis的key不能为空");
        }
    }
}
