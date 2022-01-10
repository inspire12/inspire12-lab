package com.inspire12.practice.lab.database.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    Long id;

    String name;

    @ElementCollection(targetClass = StudentSkillTag.class)
    @CollectionTable(
        name = "student_skill_tags",
        joinColumns = @JoinColumn(referencedColumnName = "id")
    )
    List<StudentSkillTag> studentSkillTags = new ArrayList<>();

    public Student(Long i, String name) {
        this.id = i;
        this.name = name;
    }
}
