package com.example.demo.security;

public class DemoUser {

    private Long id;
    private String email;

    public DemoUser(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
