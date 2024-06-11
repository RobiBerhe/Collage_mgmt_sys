package com.rob.app.department.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(Long id){
        super("Couldn't find the department with id :"+id);
    }
}
