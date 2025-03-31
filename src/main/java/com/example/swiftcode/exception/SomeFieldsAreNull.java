package com.example.swiftcode.exception;

public class SomeFieldsAreNull extends RuntimeException {
    public SomeFieldsAreNull() {
        super("fields like countryISO2,SwiftCode,Name and country name should not be null");
    }
}
