package com.rob.app.student.data;

import com.rob.app.department.domain.Department;
import com.rob.app.student.domain.Student;

public record StudentDTO(Long id, String name, String lastName, int age, Long departmentId, Department department) {

    public Student toStudent(Department d) {
        return new Student(id, name, lastName, age);
    }
}
