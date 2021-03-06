package com.owasp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AuthException extends RuntimeException {

    private static final long serialVersionUID = -2497578972043827547L;

    public AuthException(String message) {
        super(message);
    }
}
