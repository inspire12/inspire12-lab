package com.inspire12.practice.lab.web.socket.pubsub;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspire12.practice.lab.web.socket.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisSubscriber implements MessageListener {
    private final RedisTemplate<String, Object> redisTemplate;
    private final SimpMessageSendingOperations messagingTemplate;
    private final ObjectMapper mapper;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
        try {
            ChatMessage roomMessage = mapper.readValue(publishMessage, ChatMessage.class);
            messagingTemplate.convertAndSend("/sub/chat/room" + roomMessage.getMessage());
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
    }
}
