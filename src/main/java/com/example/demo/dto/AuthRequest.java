package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthRequest {
    @NotBlank(message = "Username is required")
    private String email;
    private String password;
}