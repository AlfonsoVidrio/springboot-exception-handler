package com.alfonsovidrio.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.alfonsovidrio.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.alfonsovidrio.springboot.error.springboot_error.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error> divisionByZero(Exception ex) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError("Division by zero");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new Date());

        // return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(NoHandlerFoundException ex) {
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError("Resource not found");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(new Date());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    } 

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "Number format exception");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "user or role not");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
}
