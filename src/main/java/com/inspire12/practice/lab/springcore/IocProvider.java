package com.inspire12.practice.lab.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IocProvider {


    @Bean
    SpringBasicService springCoreService() {
        return new SpringBasicService();
    }
}
