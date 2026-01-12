package com.project.url_shortener.controllers;

import com.project.url_shortener.configuration.ApplicationProperties;
import com.project.url_shortener.dtos.PagedResult;
import com.project.url_shortener.dtos.ShortUrlDTO;
import com.project.url_shortener.entities.User;
import com.project.url_shortener.enums.Role;
import com.project.url_shortener.security.SecurityUtils;
import com.project.url_shortener.services.interfaces.ShortUrlService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private ShortUrlService shortUrlService;
    private SecurityUtils securityUtils;

    private ApplicationProperties applicationProperties;

    public AdminController(ShortUrlService shortUrlService, SecurityUtils securityUtils, ApplicationProperties properties) {
        this.securityUtils = securityUtils;
        this.shortUrlService = shortUrlService;
        this.applicationProperties = properties;
    }

    @GetMapping("/all-urls")
    public PagedResult<ShortUrlDTO> getAllUrls(@RequestParam(defaultValue = "1") int pageNumber) {

    }
}
