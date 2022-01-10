package com.inspire12.practice.lab.database.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DomainEventService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public void test() {
//        applicationEventPublisher.publishEvent();

    }
}
