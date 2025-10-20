package com.project.url_shortener.entities;

import com.project.url_shortener.enums.Role;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String email;
    private String password;
    private String name;
    private Role role;
    private LocalDateTime createdAt;
}
