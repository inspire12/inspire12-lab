package com.inspire12.practice.lab.web.socket.controller;

//import com.inspire12.practice.lab.web.socket.ssevent.UserClient;
import com.inspire12.practice.lab.web.socket.model.ChatMessage;
import com.inspire12.practice.lab.web.socket.model.Message;
import com.inspire12.practice.lab.web.socket.model.OutputMessage;
import com.inspire12.practice.lab.web.socket.ssevent.UserEmitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.text.SimpleDateFormat;
import java.util.Date;
//import reactor.core.publisher.Flux;


@RestController
@RequiredArgsConstructor
public class SocketController {
    private final UserEmitService userEmitService;
//    private final UserClient userClient;

    @GetMapping(value = "/events/users", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter handle() {
        SseEmitter emitter = new SseEmitter();
        userEmitService.add(emitter);
        return emitter;
    }

//    @GetMapping(value = "/events/users/flux", produces = "application/stream+json")
//    public Flux<User> users() {
//        return Flux.interval(Duration.ofSeconds(1L))
//                .take(3)
//                .flatMap(number -> userClient.get(number + 1L));
//    }

}
