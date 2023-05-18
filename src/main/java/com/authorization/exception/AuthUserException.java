package com.authorization.exception;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

@Getter
public class AuthUserException extends RuntimeException {

    private final String message;
    private final HttpStatus status;
    private Exception cause;

    public AuthUserException(String message, HttpStatus status) {
        super();
        this.status = status;
        this.message = message;
    }

    public AuthUserException(String message, Exception cause, HttpStatus status) {
        super();
        this.cause = cause;
        this.status = status;
        this.message = message;
    }

    public AuthUserException(Exception cause, HttpStatus status) {
        super();
        this.status = status;
        this.cause = cause;
        this.message = StringUtils.EMPTY;
    }
}
