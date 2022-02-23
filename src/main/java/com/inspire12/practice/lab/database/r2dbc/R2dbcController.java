package com.inspire12.practice.lab.database.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@RestController
public class R2dbcController {
    private final CustomerService customerService;

    @GetMapping("/flux")
    public Flux<Customer> getCustomer() {
        return customerService.getCustomers();
    }
}
