package com.rob.app.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rob.app.student.domain.Student;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {
    

    Student save(Student s);
    Optional<Student> findById(Long id);
    List<Student> findAll();
}
