package com.project.url_shortener.dtos;

import java.util.List;

public record DeleteUrlsRequestDTO(
        List<Long> ids
) {
}
