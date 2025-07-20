package com.example.localchat.service;

import com.example.localchat.model.ChatMessage;
import com.example.localchat.repository.ChatHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatHistoryRepository repository;
    private final ChatGptClient client;

    public ChatService(ChatHistoryRepository repository, ChatGptClient client) {
        this.repository = repository;
        this.client = client;
    }

    public List<ChatMessage> getHistory() {
        return repository.findAll();
    }

    public ChatMessage chat(String userMessage, String model) {
        ChatMessage user = new ChatMessage("user", userMessage);
        repository.addMessage(user);
        ChatMessage response = client.requestChatCompletion(repository.findAll(), model);
        repository.addMessage(response);
        return response;
    }
}
