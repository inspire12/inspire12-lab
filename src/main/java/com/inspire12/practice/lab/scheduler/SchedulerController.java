package com.inspire12.practice.lab.scheduler;

import com.inspire12.practice.lab.scheduler.dto.ScheduleLogRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class SchedulerController {
    private final Scheduler scheduler;

    @PostMapping("/scheduler/log")
    public ResponseEntity<Object> doLog(@RequestBody ScheduleLogRequest scheduleLogRequest) {
        scheduler.startScheduler(() -> log.info("start log"), 1, scheduleLogRequest.getName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/scheduler/log/stop")
    public ResponseEntity<Object> stopLog(@RequestBody ScheduleLogRequest scheduleLogRequest) {
        scheduler.stopScheduler(scheduleLogRequest.getName());
        return ResponseEntity.ok().build();
    }

}
