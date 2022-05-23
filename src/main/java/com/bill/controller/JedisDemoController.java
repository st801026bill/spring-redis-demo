package com.bill.controller;

import com.bill.dto.RedisSetReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class JedisDemoController {
    @Autowired
    private JedisDemoService jedisDemoService;

    @PostMapping("/redis/set")
    public String set(@RequestBody RedisSetReqDto reqDto) {
        return jedisDemoService.set(reqDto.getKey(), reqDto.getValue());
    }

    @GetMapping("/redis/{key}")
    public String set(@PathVariable("key") String key) {
        return jedisDemoService.get(key);
    }
}
