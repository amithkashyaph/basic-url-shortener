package com.project.url_shortener.utils;

import com.project.url_shortener.dtos.ShortUrlDTO;
import com.project.url_shortener.dtos.UserDTO;
import com.project.url_shortener.entities.ShortUrl;
import com.project.url_shortener.entities.User;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {

    public ShortUrlDTO toShortUrlDTO(ShortUrl shortUrl) {
        UserDTO userDTO = null;
        if (shortUrl.getCreatedBy() != null) {
            userDTO = toUserDTO(shortUrl.getCreatedBy());
        }

        return new ShortUrlDTO(shortUrl.getId(), shortUrl.getShortKey(), shortUrl.getOriginalUrl(), shortUrl.getExpiresAt(), userDTO, shortUrl.getIsPrivate(), shortUrl.getCreatedAt(), shortUrl.getClickCount());
    }

    public UserDTO toUserDTO(User createdBy) {
        return new UserDTO(createdBy.getId(), createdBy.getName());
    }
}
