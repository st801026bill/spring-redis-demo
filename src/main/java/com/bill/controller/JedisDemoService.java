package com.bill.controller;

import com.bill.util.JedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JedisDemoService {
    @Autowired
    private JedisUtils jedisUtils;

    public String set(String key, String value) {
        return jedisUtils.set(key, value);
    }

    public String get(String key) {
        return jedisUtils.get(key);
    }
}
