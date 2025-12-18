package com.project.url_shortener.controllers;

import com.project.url_shortener.configuration.ApplicationProperties;
import com.project.url_shortener.dtos.*;
import com.project.url_shortener.exceptions.InvalidCredentialException;
import com.project.url_shortener.exceptions.InvalidRequestBodyException;
import com.project.url_shortener.exceptions.UserAlreadyExistsException;
import com.project.url_shortener.security.SecurityUtils;
import com.project.url_shortener.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    private SecurityUtils securityUtils;

    private ApplicationProperties applicationProperties;

    UserController(UserService userService, ApplicationProperties applicationProperties, SecurityUtils securityUtils) {
        this.userService = userService;
        this.applicationProperties = applicationProperties;
        this.securityUtils = securityUtils;
    }

}
