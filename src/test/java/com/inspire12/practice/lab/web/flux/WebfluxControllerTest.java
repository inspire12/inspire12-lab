package com.inspire12.practice.lab.web.flux;

import com.inspire12.practice.lab.extern.jsonplaceholder.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebfluxControllerTest {
    WebClient client = WebClient.create("http://localhost:8080");

    @Test
    public void test() {
        Mono<User> employeeMono = client.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(User.class);

        employeeMono.subscribe(System.out::println);
    }
}