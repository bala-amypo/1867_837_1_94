package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    },
    indexes = {
        @Index(name = "idx_user_email", columnList = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    /*
     * Stored as an ALREADY ENCRYPTED password.
     * Encryption happens in UserService / CustomUserDetailsService.
     */
    @Column(nullable = false)
    private String password;

    /*
     * Example values: ADMIN, USER
     * Required and set during registration.
     */
    @Column(nullable = false)
    private String role;

    // ---------- Constructors ----------

    public User() {
        // required by JPA
    }

    public User(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // ---------- Getters & Setters ----------

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Never expose this field in API responses.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Must already be encrypted when set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
