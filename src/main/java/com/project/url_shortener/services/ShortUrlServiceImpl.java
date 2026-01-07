package com.project.url_shortener.services;

import com.project.url_shortener.configuration.ApplicationProperties;
import com.project.url_shortener.dtos.CreateShortUrlDTO;
import com.project.url_shortener.dtos.PagedResult;
import com.project.url_shortener.dtos.ShortUrlDTO;
import com.project.url_shortener.entities.ShortUrl;
import com.project.url_shortener.exceptions.ShortKeyDoesNotExistException;
import com.project.url_shortener.repositories.ShortUrlRespository;
import com.project.url_shortener.services.interfaces.ShortUrlService;
import com.project.url_shortener.services.interfaces.UserService;
import com.project.url_shortener.utils.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int NO_OF_CHARACTERS = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    private ShortUrlRespository shortUrlRespository;
    private EntityMapper entityMapper;
    private ApplicationProperties applicationProperties;
    private UserService userService;


    @Autowired
    ShortUrlServiceImpl(ShortUrlRespository shortUrlRespository, EntityMapper entityMapper, ApplicationProperties applicationProperties, UserService userService) {
        this.shortUrlRespository = shortUrlRespository;
        this.entityMapper = entityMapper;
        this.applicationProperties = applicationProperties;
        this.userService = userService;
    }
    @Override
    public PagedResult<ShortUrlDTO> getAllShortUrls(int pageNumber, int pageSize) {
        pageNumber = pageNumber > 1 ? pageNumber - 1 : 0;
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<ShortUrlDTO> shortUrlPage = shortUrlRespository.findAllPublicUrls(pageable).map(entityMapper::toShortUrlDTO);
        return PagedResult.from(shortUrlPage);
    }

}
