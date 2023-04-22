package ru.netology.hibernate_layers.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.hibernate_layers.exception.IncorrectInputDataException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IncorrectInputDataException.class)
    public ResponseEntity<String> invalidCredentialsHandler(IncorrectInputDataException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
