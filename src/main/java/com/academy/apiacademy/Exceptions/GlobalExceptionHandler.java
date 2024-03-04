package com.academy.apiacademy.Exceptions;

import java.net.URI;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ProblemDetail handleModelNotFoundException(ModelNotFoundException exception, WebRequest request) {
        ProblemDetail problemDetdail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, exception.getMessage());
        problemDetdail.setTitle("Model not found exception");
        problemDetdail.setType(URI.create(request.getContextPath()));
        problemDetdail.setProperty("code", "404");
        problemDetdail.setProperty("message", "NOT-FOUND");

        return problemDetdail;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException exception, WebRequest request) {
        ProblemDetail problemDetdail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetdail.setTitle("Method argument not valid exception");
        problemDetdail.setType(URI.create(request.getContextPath()));
        problemDetdail.setProperty("code", "400");
        problemDetdail.setProperty("message", "BAD-REQUEST");

        return problemDetdail;
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDataIntegrityViolationException(DataIntegrityViolationException exception, WebRequest request) {
        ProblemDetail problemDetdail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
        problemDetdail.setTitle("Data integrity violation exception");
        problemDetdail.setType(URI.create(request.getContextPath()));
        problemDetdail.setProperty("code", "400");
        problemDetdail.setProperty("message", "BAD-REQUEST");

        return problemDetdail;
    }

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleException(Exception exception, WebRequest request) {
        ProblemDetail problemDetdail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        problemDetdail.setTitle("Internal server error");
        problemDetdail.setType(URI.create(request.getContextPath()));
        problemDetdail.setProperty("code", "500");
        problemDetdail.setProperty("message", "INTERNAL-SERVER-ERROR");

        return problemDetdail;
    }
}