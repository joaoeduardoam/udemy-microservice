package com.joaoeduardo.cambioservice.exceptions;


public class UnsupportedCurrencyException extends RuntimeException{
    public UnsupportedCurrencyException() {
        super("Unsupported Currency!");
    }

    public UnsupportedCurrencyException(String message) {
        super(message);
    }
}
