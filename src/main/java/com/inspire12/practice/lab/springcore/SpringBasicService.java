package com.inspire12.practice.lab.springcore;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringBasicService {

    public String hello() {
        return "hello";
    }
}
