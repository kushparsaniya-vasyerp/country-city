package dev.kush.countrycity.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionMessage(
        String message,
        HttpStatus status,
        LocalDateTime timeStamp
) {
}
