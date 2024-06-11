package com.rob.app.department.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rob.app.department.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{
    

    Department save(Department department);
    Optional<Department> findById(Long id);
    List<Department> findAll();
    Department findByName(String name);



}
