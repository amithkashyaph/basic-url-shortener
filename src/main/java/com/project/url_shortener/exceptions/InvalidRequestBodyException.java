package com.project.url_shortener.exceptions;

public class InvalidRequestBodyException extends Exception {

    public InvalidRequestBodyException(String message) {
        super(message);
    }
}
