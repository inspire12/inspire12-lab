package com.inspire12.practice.lab.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SchedulerController {
    private final Scheduler scheduler;

    @PostMapping("/scheduler/log")
    public ResponseEntity<Object> doLog() {
        scheduler.startScheduler(() -> log.info("start log"), 1, "1 * * * * *");
        return ResponseEntity.ok().build();
    }
}
