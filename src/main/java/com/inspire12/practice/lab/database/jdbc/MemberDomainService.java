package com.inspire12.practice.lab.database.jdbc;

import com.inspire12.practice.lab.database.jdbc.user.aggregate.MemberAggregateService;
import com.inspire12.practice.lab.database.jdbc.user.aggregate.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberDomainService {
    private final MemberAggregateService memberAggregateService;


    @Transactional
    public List<Member> testJpaListQuery() {
        List<Member> memberList = memberAggregateService.getMembers();
        List<Member> memberList2 = memberAggregateService.getMembers();
        return memberAggregateService.getMembers();
    }

    public void initEntity() {
        memberAggregateService.saveAll(Arrays.asList(new Member("a"), new Member("b"), new Member("c")));
    }

    @Transactional
    public void testJpaEvent(int id, String name) {
        memberAggregateService.changeName(id, name);
    }

    @Transactional
    public void test3(int id) {
        Member member = memberAggregateService.getMember(id);
//
//        Member member2 = domainService.getMember(id);
//        List<Member> memberList = dbLayerAggregateService.getMember(id);

//        dbLayerAggregateService.setMember(id, "hi");
//        member = new Member(id, "hi");
        member.changeName("hi");

//        dbLayerAggregateService.getMember(id);
        System.out.println();
    }
}
