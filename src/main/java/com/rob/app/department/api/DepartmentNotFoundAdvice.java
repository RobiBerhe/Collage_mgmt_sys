package com.rob.app.department.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rob.app.department.exception.DepartmentNotFoundException;

@RestControllerAdvice
public class DepartmentNotFoundAdvice {
    

    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departmentNotFound(DepartmentNotFoundException ex){
        return ex.getMessage();
    }
}
