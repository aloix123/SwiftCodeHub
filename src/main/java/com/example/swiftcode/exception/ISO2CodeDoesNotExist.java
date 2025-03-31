package com.example.swiftcode.exception;

public class ISO2CodeDoesNotExist extends RuntimeException {
    public ISO2CodeDoesNotExist(String code) {
        super("Iso2 "+code+" code does not exist");
    }
}
