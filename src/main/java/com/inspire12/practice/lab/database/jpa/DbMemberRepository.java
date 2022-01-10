package com.inspire12.practice.lab.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbMemberRepository extends JpaRepository<Member, Integer> {

}
