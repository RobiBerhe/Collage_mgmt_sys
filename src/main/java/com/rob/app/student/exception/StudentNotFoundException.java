package com.rob.app.student.exception;

public class StudentNotFoundException extends RuntimeException{
    
    public StudentNotFoundException(Long id){
        super("Could not find a student with an Id "+id);
    }
}
