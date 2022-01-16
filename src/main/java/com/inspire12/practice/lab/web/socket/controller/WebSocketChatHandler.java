package com.inspire12.practice.lab.web.socket.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspire12.practice.lab.web.socket.ChatRoomRepository;
import com.inspire12.practice.lab.web.socket.model.ChatMessage;
import com.inspire12.practice.lab.web.socket.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Primary
@Slf4j
@RequiredArgsConstructor
@Component
public class WebSocketChatHandler extends TextWebSocketHandler {

    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper mapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload); // 채팅 log
        ChatMessage chatMessage = mapper.readValue(payload, ChatMessage.class);
        ChatRoom room = chatRoomRepository.findRoomById(chatMessage.getRoomId());
        room.handleActions(session, chatMessage, chatRoomRepository);
    }
}