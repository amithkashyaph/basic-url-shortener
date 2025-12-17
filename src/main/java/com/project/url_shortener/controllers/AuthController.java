package com.project.url_shortener.controllers;

import com.project.url_shortener.dtos.UserDTO;
import com.project.url_shortener.dtos.UserLoginDTO;
import com.project.url_shortener.dtos.UserRegisterDTO;
import com.project.url_shortener.exceptions.UserAlreadyExistsException;
import com.project.url_shortener.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private UserService userService;

    public AuthController(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody @Valid UserRegisterDTO userRegisterDTO) throws UserAlreadyExistsException {
        UserDTO userDTO = userService.registerUser(userRegisterDTO);
        return userDTO;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO request) {
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(request.email(), request.password());

        try {
            authenticationManager.authenticate(authInputToken);
            return ResponseEntity.ok("Login successful!");
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}

