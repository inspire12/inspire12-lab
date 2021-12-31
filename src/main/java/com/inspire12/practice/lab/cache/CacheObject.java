package com.inspire12.practice.lab.cache;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
public class CacheObject {
    private int count;
    private int ttl;
    private TimeUnit unit; //second

    public CacheObject (int count){
        this.count = count;
        this.ttl = 10;
        this.unit = TimeUnit.SECONDS;
    }
}
