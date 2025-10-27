package com.project.url_shortener.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

public record ShortUrlDTO(Long id, String shortKey, String originalUrl, LocalDateTime expiresAt, UserDTO createdBy, Boolean isPrivate, LocalDateTime createdAt, Long clickCount) implements Serializable {
}
