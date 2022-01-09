package com.inspire12.practice.lab.web.controller;

import com.inspire12.practice.lab.cache.CacheLabService;
import com.inspire12.practice.lab.cache.CacheObject;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CacheController {
    private final CacheLabService cacheLabService;

    @GetMapping("/cache/test")
    private CacheObject labCache(@RequestParam(value = "index") int index) {
        return cacheLabService.getCacheObject(index);
    }

    @GetMapping("/cache/test2")
    private CacheObject labCache(@RequestParam(value = "index") int index, @RequestParam(value = "index2") int index2) {
        return cacheLabService.getCacheObject2(index, index2);
    }
}
