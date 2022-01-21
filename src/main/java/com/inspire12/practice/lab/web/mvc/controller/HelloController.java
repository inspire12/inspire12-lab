package com.inspire12.practice.lab.web.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inspire12.practice.lab.web.mvc.service.*;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.greeting();
    }
}
