package com.example.localchat.repository;

import com.example.localchat.model.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChatHistoryRepository {

    private final List<ChatMessage> messages = new ArrayList<>();

    public List<ChatMessage> findAll() {
        return messages;
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }
}
