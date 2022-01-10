package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void saveAll(List<Member> members) {
        dbMemberRepository.saveAll(members);
    }

    @Transactional
    public void changeName(int id, String name) {
        dbMemberRepository.findById(id)
                .ifPresent(entity -> {
                    entity.changeName(name);
                    dbMemberRepository.save(entity);
                });
    }
}
