package com.inspire12.practice.lab.database.jpa.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s from Student s where s.id = (:id)")
    Optional<Student> findById(long id);

    @Query("SELECT s FROM Student s JOIN s.studentSkillTags t WHERE t = LOWER(:tag)")
    List<Student> retrieveByTag(@Param("tag") String tag);
}
