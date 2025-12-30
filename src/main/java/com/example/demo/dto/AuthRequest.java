package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthRequest {


    @Email(message = "Email should be valid")
    private String email;
    
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;
}