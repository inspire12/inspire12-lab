package com.inspire12.practice.lab.web.socket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String roomId;
    private String content;
    private String sender;
    private String message;
}
