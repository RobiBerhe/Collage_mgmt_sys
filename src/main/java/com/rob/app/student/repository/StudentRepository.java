package com.rob.app.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rob.app.student.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    
}
