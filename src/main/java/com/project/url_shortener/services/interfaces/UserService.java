package com.project.url_shortener.services.interfaces;

import com.project.url_shortener.dtos.*;
import com.project.url_shortener.entities.User;
import com.project.url_shortener.exceptions.InvalidCredentialException;
import com.project.url_shortener.exceptions.InvalidRequestBodyException;
import com.project.url_shortener.exceptions.UserAlreadyExistsException;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserRegisterDTO userRegisterDTO) throws UserAlreadyExistsException;
    UserDTO loginUser(UserLoginDTO userLoginDTO) throws InvalidCredentialException;

    User getCurrentUser();

    PagedResult<ShortUrlDTO> getUsersShortUrls(int pageNumber, int pageSize, Long userId);
}
