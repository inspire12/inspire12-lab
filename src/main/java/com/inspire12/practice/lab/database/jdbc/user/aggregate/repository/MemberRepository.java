package com.inspire12.practice.lab.database.jdbc.user.aggregate.repository;

import com.inspire12.practice.lab.database.jdbc.user.aggregate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}
