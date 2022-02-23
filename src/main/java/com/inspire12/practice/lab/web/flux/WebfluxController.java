package com.inspire12.practice.lab.web.flux;

import com.inspire12.practice.lab.database.r2dbc.Customer;
import com.inspire12.practice.lab.database.r2dbc.CustomerRepository;
import com.inspire12.practice.lab.database.r2dbc.CustomerService;
import com.inspire12.practice.lab.extern.jsonplaceholder.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flux")
public class WebfluxController {

    private final CustomerService customerService;

    @GetMapping
    private Mono<Customer> getEmployeesById() {
        return customerService.getCustomer();
    }


    @GetMapping("/flux")
    private Flux<Customer> getEmployeeById() {
        return customerService.getCustomers();
    }
}
