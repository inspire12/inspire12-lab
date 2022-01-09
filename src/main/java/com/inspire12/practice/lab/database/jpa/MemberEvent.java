package com.inspire12.practice.lab.database.jpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

@Getter
public class MemberEvent extends ApplicationEvent {
    private final Member member;

    public MemberEvent(Object source) {
        super(source);
        this.member = (Member) source;
    }
//    private String comment;
}
