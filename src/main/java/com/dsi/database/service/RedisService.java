package com.dsi.database.service;

import org.springframework.stereotype.Service;

@Service
public interface RedisService {
    public void setValue(String key,String value);
    public String getValue(String key);


}
