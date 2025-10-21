package com.project.url_shortener.entities;

import java.time.LocalDateTime;

public class ShortUrl {
    private Long id;
    private String shortKey;
    private String originalUrl;
    private User user;
    private Boolean isPrivate;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;
    private Long clickCount;

}
