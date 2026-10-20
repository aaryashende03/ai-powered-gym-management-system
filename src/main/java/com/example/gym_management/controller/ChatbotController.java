package com.example.gym_management.controller;

import com.example.gym_management.chatbot.ChatbotService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }

    @GetMapping("/chatbot")
    public String showChatbot(Model model) {
        model.addAttribute("answer", null);
        return "chatbot";
    }

    @PostMapping("/chatbot")
    public String sendMessage(
            @RequestParam("message") String message,
            Model model) {

        String answer = chatbotService.getResponse(message);

        model.addAttribute("message", message);
        model.addAttribute("answer", answer);

        return "chatbot";
    }
}


