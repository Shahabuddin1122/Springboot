package com.dsi.database.controller;

import com.dsi.database.dao.StringRedisDao;
import com.dsi.database.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping
    public String getValue(@RequestBody StringRedisDao redisDao){
        return redisService.getValue(redisDao.getKey());
    }

    @PostMapping
    public void setValue(@RequestBody StringRedisDao redisDao){
        redisService.setValue(redisDao.getKey(),redisDao.getValue());
    }
}
