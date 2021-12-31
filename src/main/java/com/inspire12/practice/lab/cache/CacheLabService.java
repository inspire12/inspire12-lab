package com.inspire12.practice.lab.cache;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheLabService {

    private final CacheService<String, CacheObject> memoryCacheService;
    private final CacheManager cacheManager;

    @Cacheable("lab1")
    public CacheObject getCacheObject(int index) {
        return new CacheObject(index + 1);
    }

    @Cacheable(value = "lab2", key = "#index + #testIndex")
    public CacheObject getCacheObject2(int index, int testIndex) {
        return new CacheObject(index + testIndex);
    }

    public CacheObject getCacheObject3() {
        CacheProperties.EhCache ehCache = new CacheProperties.EhCache();
        return new CacheObject(1);
    }
}
