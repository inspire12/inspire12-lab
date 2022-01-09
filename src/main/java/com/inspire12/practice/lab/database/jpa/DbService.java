package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {
    private final DomainService domainService;
    private final DbLayerAggregateService dbLayerAggregateService;

    @Transactional
    public void test() {
        List<Member> memberList = domainService.getMembers();
//
        List<Member> memberList2 = domainService.getMembers();
        List<Member> memberList3 = dbLayerAggregateService.getMembers();
        System.out.println();
    }


    @Transactional
    public void test2(int id) {
        Member memberList = domainService.getMember(id);
//
        Member memberList2 = domainService.getMember(id);
        Member memberList3 = dbLayerAggregateService.getMember(id);

        dbLayerAggregateService.setMember(id, "hi");
        dbLayerAggregateService.getMember(id);
        System.out.println();
    }
}
