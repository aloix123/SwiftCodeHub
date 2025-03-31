package com.example.swiftcode.exception.advicer;

import com.example.swiftcode.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SwiftCodeControllerAdvicer {

    @ExceptionHandler(ISO2CodeDoesNotExist.class)
    public ResponseEntity<String> handleISO2CodeDoesNotExist(ISO2CodeDoesNotExist ex) {
        return new ResponseEntity<>("ISO2 code does not exist: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Iso2CodeException.class)
    public ResponseEntity<String> handleIso2CodeException(Iso2CodeException ex) {
        return new ResponseEntity<>("Invalid ISO2 code: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoCountryException.class)
    public ResponseEntity<String> handleNoCountryException(NoCountryException ex) {
        return new ResponseEntity<>("No country found for the given code: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SomeFieldsAreLowwerCase.class)
    public ResponseEntity<String> handleSomeFieldsAreLowwerCase(SomeFieldsAreLowwerCase ex) {
        return new ResponseEntity<>("Some fields are in lowercase: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SomeFieldsAreNull.class)
    public ResponseEntity<String> handleSomeFieldsAreNull(SomeFieldsAreNull ex) {
        return new ResponseEntity<>("Some fields are null: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SwiftCodeNotfound.class)
    public ResponseEntity<String> handleSwiftCodeNotFound(SwiftCodeNotfound ex) {
        return new ResponseEntity<>("Swift code not found: " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
