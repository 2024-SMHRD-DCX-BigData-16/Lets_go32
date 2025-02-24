package com.jtsr.demo.controller;

import com.jtsr.demo.model.ChatHistory;
import com.jtsr.demo.repository.ChatHistoryRepository;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class ChatController {
    
    private final VertexAiGeminiChatModel vertexAiGeminiChatModel;
    private final ChatHistoryRepository chatHistoryRepository;

    public ChatController(VertexAiGeminiChatModel vertexAiGeminiChatModel, ChatHistoryRepository chatHistoryRepository) {
        this.vertexAiGeminiChatModel = vertexAiGeminiChatModel;
        this.chatHistoryRepository = chatHistoryRepository;
    }

    // 🟢 채팅 요청 (DB 저장)
    @PostMapping("/chat")
    public Map<String, String> chat(@RequestBody Map<String, String> request) {
        String userId = request.get("user_id"); // 사용자 ID 받기
        String userMessage = request.get("message");

        // AI 응답 생성
        String botResponse = vertexAiGeminiChatModel.call(userMessage);

        // DB에 저장
        ChatHistory chatHistory = new ChatHistory(userId, userMessage, botResponse);
        chatHistoryRepository.save(chatHistory);

        // 응답 반환
        Map<String, String> responses = new HashMap<>();
        responses.put("user_id", userId);
        responses.put("user_message", userMessage);
        responses.put("bot_response", botResponse);
        return responses;
    }

    // 🟢 특정 사용자의 채팅 기록 조회
    @GetMapping("/chat/history/{userId}")
    public List<ChatHistory> getChatHistory(@PathVariable String userId) {
        return chatHistoryRepository.findByUserId(userId);
    }
}
