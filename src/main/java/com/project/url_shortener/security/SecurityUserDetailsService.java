package com.project.url_shortener.security;

import com.project.url_shortener.entities.User;
import com.project.url_shortener.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    SecurityUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
