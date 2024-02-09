package dev.kush.countrycity.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public Object itemNotFoundExceptionHandler(Exception ex){
        return new ExceptionMessage(ex.getMessage(), NOT_FOUND, LocalDateTime.now());
    }
}
