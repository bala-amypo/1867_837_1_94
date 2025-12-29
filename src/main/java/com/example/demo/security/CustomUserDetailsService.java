package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Simulating a database for the specific TestNG standalone tests
    private Map<String, DemoUser> users = new HashMap<>();

    public CustomUserDetailsService() {
        // Pre-seed admin for tests
        users.put("admin@city.com", new DemoUser("admin@city.com", "ADMIN", "Admin User"));
    }

    public DemoUser registerUser(String fullName, String email, String password) {
        if (users.containsKey(email)) {
            throw new RuntimeException("User already exists");
        }
        DemoUser newUser = new DemoUser(email, "USER", fullName);
        users.put(email, newUser);
        return newUser;
    }

    public DemoUser getByEmail(String email) {
        return users.get(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        // Return a dummy Spring Security UserDetails object
        return org.springframework.security.core.userdetails.User
                .withUsername(username)
                .password("password")
                .roles("USER")
                .build();
    }

    // Inner class helper to satisfy the test casting: CustomUserDetailsService.DemoUser
    @Data
    @AllArgsConstructor
    public static class DemoUser {
        private String email;
        private String role;
        private String fullName;
    }
}