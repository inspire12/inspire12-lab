package com.inspire12.practice.lab.scheduler;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Service
public class Scheduler {
    private ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    public static Map<String, ScheduledFuture<?>> scheduledFutureMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        scheduler.initialize();
    }

    @PreDestroy
    public void destroy() {
        scheduler.destroy();
    }

    public void stopScheduler() {
        for (Map.Entry<String, ScheduledFuture<?>> a :scheduledFutureMap.entrySet()) {
            a.getValue().cancel(true);
        }
    }

    public void startScheduler(Runnable work, int seconds, String scheduleName) {
        ScheduledFuture<?> task = scheduler.schedule(work, new PeriodicTrigger(seconds, TimeUnit.SECONDS));
        scheduledFutureMap.put(scheduleName, task);
    }

    public void startScheduler(Runnable work, CronExpression cronExpression, String scheduleName) {
        ScheduledFuture<?> task = scheduler.schedule(work, new CronTrigger(cronExpression.toString()));
        scheduledFutureMap.put(scheduleName, task);
    }
}
