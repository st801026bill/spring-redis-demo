package com.bill.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Component
public class JedisUtils {
    @Autowired
    JedisPool jedisPool;

    public Set<String> getAllKey() {
        Jedis jedis = jedisPool.getResource();
        Set<String> set = jedis.keys("*");
        jedis.close();
        return set;
    }

    public String set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        String set = jedis.set(key, value);// return OK
        jedis.close();
        return set;
    }

    public boolean setTime(String key, int second) {
        Jedis jedis = jedisPool.getResource();
        Long success = jedis.expire(key, second);
        jedis.close();
        if (success == 1)
            return true;
        else {
            return false;
        }
    }
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    public Long delete(String key) {
        Jedis jedis = jedisPool.getResource();
        Long quantity = jedis.del(key);
        jedis.close();
        return quantity;
    }

    public long getTime(String key) {
        Jedis jedis = jedisPool.getResource();
        Long time = jedis.ttl(key);// -1為永遠有效 -2為過期
        jedis.close();
        return time;
    }

    public Long setKeyAdd(String key) {
        Jedis jedis = jedisPool.getResource();
        Long value = jedis.incr(key);
        jedis.close();
        return value;
    }

    public Long setKeySub(String key) {
        Jedis jedis = jedisPool.getResource();
        Long value = jedis.decr(key);
        jedis.close();
        return value;
    }

    public Long setKeyAddValue(String key, Long value) {
        Jedis jedis = jedisPool.getResource();
        Long newValue = jedis.incrBy(key, value);
        jedis.close();
        return newValue;
    }

    public Long setKeySubValue(String key, Long value) {
        Jedis jedis = jedisPool.getResource();
        Long newValue = jedis.decrBy(key, value);
        jedis.close();
        return newValue;
    }
}
