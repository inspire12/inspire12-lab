package com.inspire12.practice.lab.database.jdbc.user.aggregate.event;

import com.inspire12.practice.lab.database.jdbc.user.aggregate.MemberAggregateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberListener {

    private final MemberAggregateService domainService;

    public MemberListener(MemberAggregateService domainService) {
        this.domainService = domainService;
    }

//    @TransactionalEventListener
    @EventListener
    public void onApplicationEvent(MemberEvent event) {
        System.out.println(event.getMember().getName() + " is published!");
    }
}
