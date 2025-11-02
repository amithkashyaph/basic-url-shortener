package com.project.url_shortener.exceptions;

public class ShortKeyDoesNotExistException extends Exception {
    public ShortKeyDoesNotExistException(String message) {
        super(message);
    }
}
