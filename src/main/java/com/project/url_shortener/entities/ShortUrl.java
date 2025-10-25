package com.project.url_shortener.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "short_urls")
@Getter
@Setter
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String shortKey;
    @Column(nullable = false)
    private String originalUrl;
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;
    @Column(nullable = false)
    private Boolean isPrivate;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime expiresAt;
    private Long clickCount;

}
