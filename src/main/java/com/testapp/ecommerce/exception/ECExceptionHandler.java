package com.testapp.ecommerce.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ECExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ECSubError> subErrors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().stream().forEach(e -> {
            ECSubError error = new ValidationError(e.getObjectName(), e.getField(), e.getRejectedValue(), e.getDefaultMessage());
            subErrors.add(error);

        });
        ECError error = new ECError(HttpStatus.BAD_REQUEST, LocalDateTime.now(),"Validation failed",ex.getLocalizedMessage(),subErrors);
        return ResponseEntity.badRequest().body(error);
    }
}
