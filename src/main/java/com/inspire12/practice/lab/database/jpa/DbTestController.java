package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DbTestController {
    private final DbService dbService;

    @GetMapping("/db/test")
    public void test() {
        dbService.test();
    }


    @GetMapping("/db/test2")
    public void test2() {
        dbService.test2(1);
    }
}
