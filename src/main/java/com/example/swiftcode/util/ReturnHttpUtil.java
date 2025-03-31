package com.example.swiftcode.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ReturnHttpUtil {

    public static final String SUCCESS_MESSAGE = "Success";
    public static final String ERROR_MESSAGE = "Error";
    public static final String ADDED_ENTITY_MESSAGE = "Entity added";
    public static final String DELETED_ENTITY_MESSAGE = "Entity deleted";

    private static ResponseEntity<?> createResponse(String message, HttpStatus status) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return new ResponseEntity<>(response, status);
    }

    public static ResponseEntity<?> execute(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }

    public static ResponseEntity<?> executeWithAddedMessage() {
        return createResponse(ADDED_ENTITY_MESSAGE, HttpStatus.OK);
    }

    public static ResponseEntity<?> executeWithDeletedMessage() {
        return createResponse(DELETED_ENTITY_MESSAGE, HttpStatus.OK);
    }

    public static ResponseEntity<?> executeWithSuccessMessage() {
        return createResponse(SUCCESS_MESSAGE, HttpStatus.OK);
    }

    public static ResponseEntity<?> executeWithErrorMessage(HttpStatus status) {
        return createResponse(ERROR_MESSAGE, status);
    }
}
