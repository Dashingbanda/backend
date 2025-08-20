package com.bml.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bml.backend.security.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // Simple example: you’d check DB for real users
    @PostMapping("/login")
    public Map<String, String> login(@RequestParam String username, @RequestParam String password) {
        Map<String, String> response = new HashMap<>();

        if ("user".equals(username) && "password".equals(password)) { // Dummy login
            String token = jwtUtil.generateToken(username);
            response.put("token", token);
        } else {
            response.put("error", "Invalid credentials");
        }

        return response;
    }
}
