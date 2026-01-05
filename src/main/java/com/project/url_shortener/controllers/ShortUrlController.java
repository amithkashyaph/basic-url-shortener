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

    @GetMapping("/short-urls")
    public PagedResult<ShortUrlDTO> getAllShortUrls(@RequestParam(defaultValue = "1") Integer page) {
        PagedResult<ShortUrlDTO> shortUrls = shortUrlService.getAllShortUrls(page, applicationProperties.pageSize());
        return shortUrls;
    }

    @PostMapping("/short-urls/create")
    public ShortUrlDTO createShortUrl(@RequestBody @Valid CreateShortUrlDTO createShortUrlDTO) {
        ShortUrlDTO shortUrlDTO = shortUrlService.createShortUrl(createShortUrlDTO);
        return shortUrlDTO;
    }

    @GetMapping("/short-urls/{shortKey}")
    public ShortUrlDTO getOriginalUrlFromShortKey(@PathVariable String shortKey) throws ShortKeyDoesNotExistException {
        ShortUrlDTO shortUrlDTO = shortUrlService.getOriginalUrlFromShortKey(shortKey);
        return shortUrlDTO;
    }

}
