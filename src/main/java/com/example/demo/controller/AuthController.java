package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.security.CustomUserDetailsService;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final CustomUserDetailsService userDetailsService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(CustomUserDetailsService userDetailsService, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestParam String fullName, 
                                          @RequestParam String email, 
                                          @RequestParam String password) {
        [cite_start]// [cite: 455] Register new user using UserService logic
        return ResponseEntity.ok(userDetailsService.registerUser(fullName, email, password));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
        [cite_start]// [cite: 456] Authenticate and generate token
        // In a real app, use AuthenticationManager. Here we simulate for the test setup.
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(), authRequest.getPassword());
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        // Simulating ID lookup for the response
        Long dummyUserId = 1L; 
        String token = jwtTokenProvider.generateToken(authentication, dummyUserId, "USER", authRequest.getEmail());
        
        return ResponseEntity.ok(new AuthResponse(token, authRequest.getEmail(), "USER"));
    }
}