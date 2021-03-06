package com.inspire12.practice.lab.web.socket.model;

import com.inspire12.practice.lab.web.socket.ChatRoomRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom implements Serializable {
    private static final long serialVersionUID = 6494678977089006639L;
    private String roomId;
    private String name;
//    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }
//
//    public void handleActions(WebSocketSession session, ChatMessage chatMessage, ChatRoomRepository chatRoomRepository) {
//        if (chatMessage.getType().equals(MessageType.ENTER)) {
//            sessions.add(session);
//            chatMessage.setContent(chatMessage.getSender() + " 님이 입장했습니다");
//            chatMessage.setMessage(chatMessage.getSender() + " 님이 입장했습니다");
//        }
//
//        sendMessage(chatMessage, chatRoomRepository);
//
//    }
//    public <T> void sendMessage(T message, ChatRoomRepository chatRoomRepository) {
//        sessions.parallelStream().forEach(session -> {
//            chatRoomRepository.sendMessage(session, message);
//        });
//    }
}
