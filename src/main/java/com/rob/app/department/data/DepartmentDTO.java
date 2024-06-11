package com.rob.app.department.data;

import java.util.List;

import com.rob.app.student.domain.Student;

public record DepartmentDTO(Long id, String name, List<Student> students) {
}
