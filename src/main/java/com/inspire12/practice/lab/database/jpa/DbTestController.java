package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DbTestController {
    private final DbService dbService;

    @GetMapping("/db/test1")
    public List<Member> test() {
        return dbService.testJpaListQuery();
    }


    @GetMapping("/db/test2")
    public void test2() {
        dbService.testJpaEvent(1, "hi");
    }

    @GetMapping("/db/setting")
    public void saveTestSetting() {
        dbService.initEntity();
    }
}
