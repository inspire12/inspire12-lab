package com.inspire12.practice.lab.scheduler.dto;

import lombok.Value;

@Value
public class ScheduleLogRequest {
    String name;
    String cron;
}
