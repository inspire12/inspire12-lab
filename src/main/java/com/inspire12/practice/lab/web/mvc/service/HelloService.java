package com.inspire12.practice.lab.web.mvc.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class HelloService {

    // fault tolerance library 서비스 장애가 전파되지 않도록 정의
    @CircuitBreaker(name = "hello", fallbackMethod = "helloFallback")
    public String greeting() {
        randomException();
        return "hello world!";
    }

    private void randomException() {
        int randomInt = ThreadLocalRandom.current().nextInt(10);

        if(randomInt <= 7) {
            throw new RuntimeException("failed");
        }
    }

    private String helloFallback(Throwable t) {
        return "fallback invoked! exception type : " + t.getClass();
    }
}
