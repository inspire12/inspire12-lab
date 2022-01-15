package com.inspire12.practice.lab.database.ddd.user.aggregate.event;

import com.inspire12.practice.lab.database.ddd.user.aggregate.entity.Member;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MemberEvent extends ApplicationEvent {
    private final Member member;

    public MemberEvent(Object source) {
        super(source);
        this.member = (Member) source;
    }
//    private String comment;
}
