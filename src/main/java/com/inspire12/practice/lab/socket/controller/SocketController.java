package com.inspire12.practice.lab.socket.controller;

import com.inspire12.practice.lab.extern.jsonplaceholder.User;
import com.inspire12.practice.lab.socket.ssevent.UserClient;
import com.inspire12.practice.lab.socket.ssevent.UserEmitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.Duration;

@RestController
@RequiredArgsConstructor
public class SocketController {
    private final UserEmitService userEmitService;
    private final UserClient userClient;

    @GetMapping(value = "/events/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter handle() throws IOException {
        SseEmitter emitter = new SseEmitter();
        userEmitService.add(emitter);
        return emitter;
    }

    @GetMapping(value = "/events/users/flux", produces = "application/stream+json")
    public Flux<User> users() {
        return Flux.interval(Duration.ofSeconds(1L))
                .take(3)
                .flatMap(number -> userClient.get(number + 1L));
    }
}
