package com.inspire12.practice.lab.web.socket.controller;

import com.inspire12.practice.lab.security.JwtTokenProvider;
import com.inspire12.practice.lab.web.socket.ChatRoomRepository;
import com.inspire12.practice.lab.web.socket.model.ChatMessage;
import com.inspire12.practice.lab.web.socket.model.MessageType;
import com.inspire12.practice.lab.web.socket.pubsub.RedisPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final RedisPublisher redisPublisher;
    private final ChatRoomRepository chatRoomRepository;
    private final JwtTokenProvider jwtTokenProvider;
    // publisher

    private final ChannelTopic channelTopic;

    @MessageMapping("/chat/message")
    public void message(ChatMessage message, @Header("token") String token) {
        String nickname = jwtTokenProvider.getUserNameFromJwt(token);
        message.setSender(nickname);

        if (MessageType.JOIN.equals(message.getType())) {
            message.setSender("[알림]");
            message.setMessage(message.getSender() + "님이 입장하셨습니다");
        }
//        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
//        redisPublisher.publish(chatRoomRepository.getTopic(message.getRoomId()), message);
        // Websocket에 발행된 메시지를 redis로 발행 (publish)
        messagingTemplate.convertAndSend(channelTopic.getTopic(), message);
    }

}
