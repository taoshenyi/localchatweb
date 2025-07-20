package com.example.localchat.controller;

import com.example.localchat.model.ChatMessage;
import com.example.localchat.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", chatService.getHistory());
        return "index";
    }

    @PostMapping("/chat")
    public String chat(@RequestParam("message") String message,
                       @RequestParam(value = "model", defaultValue = "gpt-3.5-turbo") String model,
                       Model uiModel) {
        ChatMessage response = chatService.chat(message, model);
        uiModel.addAttribute("messages", chatService.getHistory());
        return "index";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file,
                         Model model) throws IOException {
        // TODO: implement file recognition for images/audio/video
        // For now we just add a placeholder message
        chatService.getHistory().add(new ChatMessage("system",
                "Received file: " + file.getOriginalFilename()));
        model.addAttribute("messages", chatService.getHistory());
        return "index";
    }
}
