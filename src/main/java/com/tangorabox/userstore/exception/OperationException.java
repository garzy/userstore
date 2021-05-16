package com.tangorabox.userstore.exception;

import org.springframework.http.HttpStatus;

public class OperationException extends RuntimeException {

    private final HttpStatus status;

    public OperationException(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
