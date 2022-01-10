package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final DomainService domainService;
    private final DbLayerAggregateService dbLayerAggregateService;
    private final DbMemberRepository dbMemberRepository;

    @Transactional
    public List<Member> testJpaListQuery() {
        List<Member> memberList = domainService.getMembers();
        List<Member> memberList2 = domainService.getMembers();
        return dbLayerAggregateService.getMembers();
    }

    public void initEntity() {
        domainService.saveAll(Arrays.asList(new Member("a"), new Member("b"), new Member("c")));
    }

    @Transactional
    public void testJpaEvent(int id, String name) {
        domainService.changeName(id, name);
        System.out.println("when commit test ");
//        test3(id);
    }

    @Transactional
    public void test3(int id) {

        Member member = domainService.getMember(id);
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
