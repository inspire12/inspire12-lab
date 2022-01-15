package com.inspire12.practice.lab.database.ddd;

import com.inspire12.practice.lab.database.ddd.user.aggregate.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DddMemberController {
    private final MemberDomainService memberService;

    @GetMapping("/db/test1")
    public List<Member> test() {
        return memberService.testJpaListQuery();
    }


    @GetMapping("/db/test2")
    public void test2() {
        memberService.testJpaEvent(1, "hi");
    }

    @GetMapping("/db/setting")
    public void saveTestSetting() {
        memberService.initEntity();
    }
}
