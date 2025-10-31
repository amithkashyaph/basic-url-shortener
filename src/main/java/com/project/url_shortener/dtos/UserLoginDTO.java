package com.project.url_shortener.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(
        String email,
        String password) {
}
