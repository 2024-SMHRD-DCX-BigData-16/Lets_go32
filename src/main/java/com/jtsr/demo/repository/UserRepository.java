package com.jtsr.demo.repository;

import com.jtsr.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserEmail(String userEmail); // 이메일 중복 검사
}
