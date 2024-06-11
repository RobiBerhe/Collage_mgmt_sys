package com.rob.app.student.service;


import java.util.List;

import com.rob.app.student.data.StudentDTO;

public interface StudentService {
    StudentDTO createStudent(StudentDTO student);
    List<StudentDTO> listStudents();
}
