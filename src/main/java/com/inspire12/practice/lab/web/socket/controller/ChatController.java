package com.inspire12.practice.lab.web.socket.controller;

import com.inspire12.practice.lab.web.socket.ChatRoomRepository;
import com.inspire12.practice.lab.web.socket.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/room")
public class ChatController {
    private final ChatRoomRepository chatRoomRepository;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name) {
        return chatRoomRepository.createRoom(name);
    }

    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatRoomRepository.findAllRoom();
    }
}
