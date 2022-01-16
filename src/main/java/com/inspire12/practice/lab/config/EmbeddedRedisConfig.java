package com.inspire12.practice.lab.config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Profile("test-local")
@Configuration
public class EmbeddedRedisConfig {

    private final RedisProperties redisProperties;
    private RedisServer redisServer;

    public EmbeddedRedisConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @PostConstruct
    public void redisServer() {
        redisServer = RedisServer.builder()
                .setting("maxmemory " + "128M")
                .port(redisProperties.getPort())
                .build();

        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}
