package com.colorly.backend.exception;

import org.springframework.http.HttpStatus;

public class HTTPErrorException extends RuntimeException {
    private HttpStatus status;

    public HTTPErrorException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
