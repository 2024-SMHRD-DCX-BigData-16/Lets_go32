package com.jtsr.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_history")
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "user_message", columnDefinition = "TEXT", nullable = false)
    private String userMessage;

    @Column(name = "bot_response", columnDefinition = "TEXT", nullable = false)
    private String botResponse;

    @Column(name = "chat_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime chatTime;

    public ChatHistory() {}

    public ChatHistory(String userId, String userMessage, String botResponse) {
        this.userId = userId;
        this.userMessage = userMessage;
        this.botResponse = botResponse;
        this.chatTime = LocalDateTime.now();
    }

    public Long getChatId() {
        return chatId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getBotResponse() {
        return botResponse;
    }

    public LocalDateTime getChatTime() {
        return chatTime;
    }
}
