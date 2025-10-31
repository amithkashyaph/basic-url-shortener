package com.project.url_shortener.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserLoginDTO(
        @NotBlank(message = "Email address cannot be empty")
        String email,
        @NotBlank(message = "Password cannot be empty")
        String password) {
}
