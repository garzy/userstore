package com.tangorabox.userstore.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        final String violations = ex.getAllErrors().stream()
                .map(objectError -> String.format("%s -> %s", Arrays.toString(objectError.getCodes()), objectError.getDefaultMessage()))
                .collect(Collectors.joining("\n"));
        response.setMessage("Constraint Violations: " + violations);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OperationException.class)
    public ResponseEntity<Object> handleExceptions(OperationException exception) {
        ExceptionResponse response = new ExceptionResponse(exception);
        return new ResponseEntity<>(response, exception.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleException(ConstraintViolationException exception) {
        ExceptionResponse response = new ExceptionResponse();
        final String violations = exception.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessageTemplate)
                .collect(Collectors.joining("\n"));
        response.setMessage("Constraint Violations: " + violations);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
