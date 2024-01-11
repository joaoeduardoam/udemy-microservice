package com.joaoeduardo.cambioservice.infra;


import com.joaoeduardo.cambioservice.exceptions.UnsupportedCurrencyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UnsupportedCurrencyException.class)
    public ResponseEntity handler404Error(UnsupportedCurrencyException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unsupported Currency!");

    }
}
