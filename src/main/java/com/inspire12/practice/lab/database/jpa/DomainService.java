package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainService {
    private final DbMemberRepository dbMemberRepository;

    public List<Member> getMembers() {
        return dbMemberRepository.findAll();
    }

    public Member getMember(int id) {
        return dbMemberRepository.findById(id).get();
    }
}
