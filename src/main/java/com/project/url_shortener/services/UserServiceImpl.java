package com.project.url_shortener.services;

import com.project.url_shortener.dtos.*;
import com.project.url_shortener.entities.User;
import com.project.url_shortener.enums.Role;
import com.project.url_shortener.exceptions.InvalidCredentialException;
import com.project.url_shortener.exceptions.InvalidRequestBodyException;
import com.project.url_shortener.exceptions.UserAlreadyExistsException;
import com.project.url_shortener.repositories.ShortUrlRespository;
import com.project.url_shortener.repositories.UserRepository;
import com.project.url_shortener.repositories.UserRepositoryJdbcClient;
import com.project.url_shortener.services.interfaces.UserService;
import com.project.url_shortener.utils.EntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private EntityMapper entityMapper;

    private ShortUrlRespository shortUrlRespository;

    private UserRepositoryJdbcClient userRepositoryJdbcClient;

    UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, EntityMapper entityMapper, ShortUrlRespository shortUrlRespository, UserRepositoryJdbcClient userRepositoryJdbcClient) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.entityMapper = entityMapper;
        this.shortUrlRespository = shortUrlRespository;
        this.userRepositoryJdbcClient = userRepositoryJdbcClient;
    }

}
