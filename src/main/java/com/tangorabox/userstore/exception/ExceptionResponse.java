package com.tangorabox.userstore.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExceptionResponse {

    private String message;
    private LocalDateTime dateTime;

    public ExceptionResponse() {
        setDateTime(LocalDateTime.now());
    }

    public ExceptionResponse(OperationException exception) {
        setDateTime(LocalDateTime.now());
        setMessage(exception.getStatus().getReasonPhrase());
    }
}
