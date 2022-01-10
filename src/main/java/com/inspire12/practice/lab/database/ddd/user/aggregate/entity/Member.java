package com.inspire12.practice.lab.database.ddd.user.aggregate.entity;


import com.inspire12.practice.lab.database.ddd.user.aggregate.event.MemberEvent;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// root aggregate
@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@EqualsAndHashCode(callSuper = false)
public class Member extends AbstractAggregateRoot<Member> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    public Member() {
    }

    public Member(String name) {
        setId(null);
        setName(name);
    }

    public void changeName(String name) {
        setName(name);
        registerEvent(new MemberEvent(this)); //, "name change to " + name));
    }

    /**
     * All domain events currently captured by the aggregate.
     */
//    @DomainEvents
//    protected Collection<Object> domainEvents() {
//        return Collections.unmodifiableList(memberEvents);
//    }
}
