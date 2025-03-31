package com.example.swiftcode.exception;

public class Iso2CodeException extends RuntimeException {
    public Iso2CodeException(String message) {
        super(message);
    }
    public Iso2CodeException() {
        super("Iso2 code is not valid, please enter valid iso2 code");
    }
}
