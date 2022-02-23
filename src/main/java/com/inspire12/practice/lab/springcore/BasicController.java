package com.inspire12.practice.lab.springcore;

import org.springframework.web.bind.annotation.GetMapping;


public class BasicController {

    private final SpringBasicService springBasicService;

    public BasicController(SpringBasicService springBasicService) {
        this.springBasicService = springBasicService;
    }

    @GetMapping("/hello")
    public String hello() {
        return springBasicService.hello();
    }

}
