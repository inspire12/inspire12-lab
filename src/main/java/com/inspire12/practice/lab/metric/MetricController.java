package com.inspire12.practice.lab.metric;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MetricController {
    public MetricController(MeterRegistry registry) {

    }
}
