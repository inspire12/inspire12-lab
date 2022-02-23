package com.inspire12.practice.lab.database.r2dbc;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

    Flux<Customer> findAllByLastName(String lastName);
    Mono<Customer> findByLastName(String lastName);
}
