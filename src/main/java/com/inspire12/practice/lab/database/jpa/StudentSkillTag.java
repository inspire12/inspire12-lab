package com.inspire12.practice.lab.database.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.MapsId;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Embeddable
@Table(name = "student_skill_tags")
public class StudentSkillTag {

    private String name;
    private int value;

    public StudentSkillTag(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
