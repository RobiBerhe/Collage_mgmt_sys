package com.rob.app.student.api.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rob.app.student.exception.StudentNotFoundException;

@RestControllerAdvice
public class StudentNotFoundAdvice {


    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFound(StudentNotFoundException ex){
        return ex.getMessage();
    }
    
}
