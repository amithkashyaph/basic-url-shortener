package com.project.url_shortener.controllers;

import com.project.url_shortener.configuration.ApplicationProperties;
import com.project.url_shortener.dtos.CreateShortUrlDTO;
import com.project.url_shortener.dtos.PagedResult;
import com.project.url_shortener.dtos.ShortUrlDTO;
import com.project.url_shortener.entities.ShortUrl;
import com.project.url_shortener.exceptions.ShortKeyDoesNotExistException;
import com.project.url_shortener.services.interfaces.ShortUrlService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShortUrlController {

    private ShortUrlService shortUrlService;
    private ApplicationProperties applicationProperties;

    @Autowired
    ShortUrlController(ShortUrlService shortUrlService, ApplicationProperties applicationProperties) {
        this.shortUrlService = shortUrlService;
        this.applicationProperties = applicationProperties;
    }


}
