package com.example.swiftcode.exception;

public class SwiftCodeNotfound extends RuntimeException {
    public SwiftCodeNotfound() {
        super("switf code with that id not found");
    }
}
