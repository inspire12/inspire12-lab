package com.inspire12.practice.lab.database.r2dbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Flux<Customer> getCustomers() {
        return customerRepository.findAllByLastName("seo");
    }

    public Mono<Customer> getCustomer() {
        return customerRepository.findByLastName("seo");
    }
}
