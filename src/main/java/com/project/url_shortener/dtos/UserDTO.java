package com.project.url_shortener.dtos;

import java.io.Serializable;

public record UserDTO(Long id, String name) implements Serializable {
}
