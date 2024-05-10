package com.demo.holidaycalendar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

 @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex){
     System.out.println("COming in Exception");
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
             body("An Exception Occured: " + ex.getMessage());
 }
}
