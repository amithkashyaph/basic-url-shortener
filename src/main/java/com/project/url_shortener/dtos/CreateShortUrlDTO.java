package com.project.url_shortener.dtos;

import jakarta.validation.constraints.NotBlank;

public record CreateShortUrlDTO(
        @NotBlank(message = "Original URL cannot be blank")
        String originalUrl) {
}
