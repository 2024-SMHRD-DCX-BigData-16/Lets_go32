package com.jtsr.demo.controller;

import com.jtsr.demo.model.User;
import com.jtsr.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    @ResponseBody
    public String registerUser(@RequestParam Map<String, String> params) {
        if (userRepository.existsByUserEmail(params.get("userEmail"))) {
            return "이미 가입된 이메일입니다!";
        }

        User newUser = new User();
        newUser.setUserId(params.get("userId"));
        newUser.setUserPw(passwordEncoder.encode(params.get("userPw"))); // 비밀번호 암호화
        newUser.setUserName(params.get("userName"));
        newUser.setUserEmail(params.get("userEmail"));
        newUser.setGender(User.Gender.valueOf(params.get("gender")));

        userRepository.save(newUser);
        return "회원가입 성공!";
    }
}
