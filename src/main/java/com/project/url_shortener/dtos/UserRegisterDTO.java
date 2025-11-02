package com.project.url_shortener.dtos;

import com.project.url_shortener.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    private String email;
    private String password;
    private Role role = Role.ROLE_USER;
}
