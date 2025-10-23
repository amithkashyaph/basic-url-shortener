package com.project.url_shortener.services;

import com.project.url_shortener.entities.ShortUrl;
import com.project.url_shortener.repositories.ShortUrlRespository;
import com.project.url_shortener.services.interfaces.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private ShortUrlRespository shortUrlRespository;

    @Autowired
    ShortUrlServiceImpl(ShortUrlRespository shortUrlRespository) {
        this.shortUrlRespository = shortUrlRespository;
    }
    @Override
    public List<ShortUrl> getAllShortUrls() {
        return null;
    }
}
