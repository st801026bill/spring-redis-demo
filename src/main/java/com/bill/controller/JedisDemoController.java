package com.bill.controller;

import com.bill.dto.RedisSetReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "JedisDemoController", description = "JedisDemoController")
@RestController
public class JedisDemoController {
    @Autowired
    private JedisDemoService jedisDemoService;

    @Operation(summary = "set", description = "set")
    @PostMapping("/redis/set")
    public void set(@RequestBody RedisSetReqDto reqDto) {
        jedisDemoService.set(reqDto.getKey(), reqDto.getValue());
    }

    @Operation(summary = "get", description = "get")
    @GetMapping("/redis/{key}")
    public String set(@PathVariable("key") String key) {
        return jedisDemoService.get(key);
    }
}
