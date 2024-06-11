package com.rob.app.department.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rob.app.department.data.DepartmentDTO;
import com.rob.app.department.domain.Department;
import com.rob.app.department.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.name());
        departmentRepository.save(department);
        return Department.toDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> listDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(Department::toDepartmentDTO).collect(Collectors.toList());
    }

}
