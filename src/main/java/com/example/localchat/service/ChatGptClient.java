package com.example.localchat.service;

import com.example.localchat.model.ChatMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * Simplified client that would call the ChatGPT API.
 * For a real application, integrate OpenAI's APIs here.
 */
@Component
public class ChatGptClient {

    @Value("${chatgpt.api-key:}")
    private String apiKey;

    public ChatMessage requestChatCompletion(List<ChatMessage> history, String model) {
        // TODO: integrate ChatGPT API call using apiKey and model
        // This is a placeholder that simply echoes the last user message.
        String lastUserMsg = history.isEmpty() ? "" : history.get(history.size() - 1).getContent();
        return new ChatMessage("assistant", "Echo: " + lastUserMsg);
    }
}
