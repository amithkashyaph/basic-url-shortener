package com.project.url_shortener.services.interfaces;

import com.project.url_shortener.dtos.CreateShortUrlDTO;
import com.project.url_shortener.dtos.PagedResult;
import com.project.url_shortener.dtos.ShortUrlDTO;
import com.project.url_shortener.entities.ShortUrl;
import com.project.url_shortener.exceptions.ShortKeyDoesNotExistException;

import java.util.List;

public interface ShortUrlService {
    PagedResult<ShortUrlDTO> getAllShortUrls(int pageNumber, int pageSize);


}
