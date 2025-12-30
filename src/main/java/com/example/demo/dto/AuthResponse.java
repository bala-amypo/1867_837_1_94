package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String token;

    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Role is required")
    private String role;
}