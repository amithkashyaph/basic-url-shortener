package com.project.url_shortener.entities;

import com.project.url_shortener.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String name;
    private Role role;
    private LocalDateTime createdAt = LocalDateTime.now();
}
