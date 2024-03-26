package com.dsi.database.service.implententation;

import com.dsi.database.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

//    private final StringRedisTemplate redisTemplate;
//
//    public RedisServiceImpl(StringRedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }


    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
//        redisTemplate.opsForHash().put(key,"ABC",value);
        redisTemplate.expire(key,50, TimeUnit.SECONDS);
    }

    @Override
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
