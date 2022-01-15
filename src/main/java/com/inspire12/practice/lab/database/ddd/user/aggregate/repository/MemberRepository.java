package com.inspire12.practice.lab.database.ddd.user.aggregate.repository;

import com.inspire12.practice.lab.database.ddd.user.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
