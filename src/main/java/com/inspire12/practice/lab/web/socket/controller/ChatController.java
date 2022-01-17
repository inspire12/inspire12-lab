package com.inspire12.practice.lab.web.socket.controller;

import com.inspire12.practice.lab.web.socket.ChatRoomRepository;
import com.inspire12.practice.lab.web.socket.model.ChatMessage;
import com.inspire12.practice.lab.web.socket.model.MessageType;
import com.inspire12.practice.lab.web.socket.pubsub.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;

    // publisher
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (MessageType.JOIN.equals(message.getType())) {
            message.setMessage(message.getSender() + "님이 입장하셨습니다");
        }
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
    }

}
