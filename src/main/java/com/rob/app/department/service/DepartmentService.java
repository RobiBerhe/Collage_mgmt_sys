package com.rob.app.department.service;

import java.util.List;

import com.rob.app.department.data.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> listDepartments();
}
