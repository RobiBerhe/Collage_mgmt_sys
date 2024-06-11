package com.rob.app.department.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rob.app.department.data.DepartmentDTO;
import com.rob.app.department.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("list")
    public List<DepartmentDTO> listDepartments(){
        return departmentService.listDepartments();
    }

}
