package com.bill.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {
    @Value("${spring.redis.host}")
    String host;
    @Value("${spring.redis.port}")
    int port;
    @Value("${spring.redis.timeout}")
    int time;
    @Value("${spring.redis.jedis.pool.max-active}")
    int poolTotal;
    @Value("${spring.redis.jedis.pool.max-idle}")
    int maxIdle;
    @Value("${spring.redis.jedis.pool.min-idle}")
    int minIdle;
    @Bean
    public JedisPool JedisPoolUtil() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setTestOnBorrow(true);
        poolConfig.setMaxTotal(poolTotal);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(time);
        poolConfig.setTestWhileIdle(true);
        return new JedisPool(poolConfig, host, port);
    }
}
