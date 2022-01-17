package com.inspire12.practice.lab.cache;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
public class CacheObject implements Serializable {
    private static final long serialVersionUID = 4074910516288216600L;
    private int count;
    private int ttl;
    private TimeUnit unit; //second

    @Builder
    public CacheObject (int count){
        this.count = count;
        this.ttl = 10;
        this.unit = TimeUnit.SECONDS;
    }
}
