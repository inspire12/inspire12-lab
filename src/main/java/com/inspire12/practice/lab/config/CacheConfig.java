package com.inspire12.practice.lab.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

//@EnableAutoConfiguration(exclude = ElastiCacheAutoConfiguration.class)
@Configuration
@EnableCaching
public class CacheConfig {

    @Primary
    @Bean(name = "cacheManager")
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }

    @Bean(name = "redisCacheManager")
    public CacheManager redisCacheManager(RedisConnectionFactory connectionFactory,
                                     ResourceLoader resourceLoader) {
        
        // classloader 이슈 https://brunch.co.kr/@springboot/212
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(10));
        redisCacheConfiguration = redisCacheConfiguration.serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                        new JdkSerializationRedisSerializer(resourceLoader.getClassLoader())
                )
        );
        return RedisCacheManager.builder()
                .fromConnectionFactory(connectionFactory)
                .cacheDefaults(redisCacheConfiguration).build();
    }

    @Bean(name = "ehCacheCacheManager")
    public CacheManager ehCacheCacheManager() {
        CacheManager cacheManager = new EhCacheCacheManager();
        return cacheManager;
    }
}
