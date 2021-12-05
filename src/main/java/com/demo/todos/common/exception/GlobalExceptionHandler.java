package com.demo.todos.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CNotFoundException.class)
    public ResponseEntity notFoundException(CNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorCode.NOT_FOUND);
    }

    @ExceptionHandler(value = CBadRequestException.class)
    public ResponseEntity badRequestException(CBadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorCode.BAD_REQUEST);
    }

}
