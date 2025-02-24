package com.jtsr.demo.repository;

import com.jtsr.demo.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {
    List<ChatHistory> findByUserId(String userId); // 특정 사용자의 채팅 기록 조회
}
