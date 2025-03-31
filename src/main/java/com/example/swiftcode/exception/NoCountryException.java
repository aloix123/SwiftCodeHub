package com.example.swiftcode.exception;


public class NoCountryException extends RuntimeException {
    public NoCountryException(String message) {
        super(message);
    }

    public NoCountryException() {
        super("No country found");
    }
}
