package com.inspire12.practice.lab.database.jpa;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PRIVATE)
@Entity
@EqualsAndHashCode
public class Member extends AbstractAggregateRoot<Member> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

//    @Transient
//    private final List<MemberEvent> memberEvents;

    public Member() {
//        this.memberEvents = new ArrayList<>();
    }

    public Member(String name) {
        setId(null);
        setName(name);
//        this.memberEvents = new ArrayList<>();
    }


    public Member changeName(String name) {
        this.name = name;
//        memberEvents.add(new MemberEvent(this, "name change to " + name));
        registerEvent(new MemberEvent(this)); //, "name change to " + name));

        return this;
    }

//    @AfterDomainEventPublication
//    protected void clearDomainEvents() {
//        this.memberEvents.clear();
//    }

    /**
     * All domain events currently captured by the aggregate.
     */
//    @DomainEvents
//    protected Collection<Object> domainEvents() {
//        return Collections.unmodifiableList(memberEvents);
//    }
}
