package com.quizendpoint.AOP;

import com.quizendpoint.exception.*;
import com.quizendpoint.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity handleException(Exception e){
        return new ResponseEntity(ErrorResponse.builder().message("SomeThing Unexpected Happening").build(), HttpStatus.OK);
    }

    @ExceptionHandler(value = {IdNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleDemoNotFoundException(IdNotFoundException e){
        return new ResponseEntity(ErrorResponse.builder().message(e.getMessage()).build(), HttpStatus.OK);
    }

}
