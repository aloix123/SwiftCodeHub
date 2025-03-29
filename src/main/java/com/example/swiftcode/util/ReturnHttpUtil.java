package com.example.swiftcode.util;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@UtilityClass
public class ReturnHttpUtil {

    public static ResponseEntity<?> execute(Object object,HttpStatus status) {
        return new ResponseEntity<>(object,status);
    }

    public static ResponseEntity<?> execute(HttpStatus status) {
        return new ResponseEntity<>(status);
    }
}
