package com.inspire12.practice.lab.database.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class MemberListener {

    private final DomainService domainService;

    public MemberListener(DomainService domainService) {
        this.domainService = domainService;
    }

//    @TransactionalEventListener
    @EventListener
    public void onApplicationEvent(MemberEvent event) {
        System.out.println(event.getMember().getName() + " is published!");
    }
}
