package com.inspire12.practice.lab.database.jpa.join;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class JpaLabController {
    private final StudentRepository studentRepository;

    @Transactional
    @GetMapping("/jpa/test")
    public Student test() {

        Student student = new Student(1L, "Will");
        StudentSkillTag skillSet = new StudentSkillTag("java", 5);
        student.setStudentSkillTags(Arrays.asList(skillSet));
        studentRepository.save(student);

        return studentRepository.findById(1L).get();
    }
}
