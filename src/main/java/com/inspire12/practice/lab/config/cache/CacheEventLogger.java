//package com.inspire12.practice.lab.config.cache;
//
//import lombok.extern.slf4j.Slf4j;
//import org.ehcache.event.CacheEvent;
//import org.ehcache.event.CacheEventListener;
//import org.springframework.context.annotation.Configuration;
//
//@Slf4j
//@Configuration
//public class CacheEventLogger implements CacheEventListener<Object, Object> {
//    // ...
//
//    @Override
//    public void onEvent(CacheEvent<? extends Object, ? extends Object> cacheEvent) {
//        log.info("cache on", cacheEvent.getKey(), cacheEvent.getOldValue(), cacheEvent.getNewValue());
//    }
//}
