//package com.inspire12.practice.lab.web.socket.ssevent;
//
//import com.inspire12.practice.lab.extern.jsonplaceholder.User;
//import com.inspire12.practice.lab.measure.TimeChecker;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Flux;
//
//@Component
//public class UserClient {
//
//    @TimeChecker
//    public Flux<User> get(long id) {
//        return WebClient.create("https://jsonplaceholder.typicode.com")
//                .get()
//                .uri("/users/{id}", id)
//                .retrieve()
//                .bodyToFlux(User.class);
//    }
//}
