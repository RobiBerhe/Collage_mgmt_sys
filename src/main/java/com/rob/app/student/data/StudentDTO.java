package com.rob.app.student.data;

import com.rob.app.department.domain.Department;

public record StudentDTO(Long id, String name, String lastName, int age, Long departmentId, Department department) {
}
