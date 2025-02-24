package com.jtsr.demo.dto;

public class ChatRequest {
    private String message;

    // 기본 생성자 필요 (Spring이 JSON 변환 시 사용)
    public ChatRequest() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
