package com.rob.app.department.domain;

import java.util.List;

import com.rob.app.department.data.DepartmentDTO;
import com.rob.app.student.domain.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    private @Id @GeneratedValue Long id;
    private String name;
    @OneToMany
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public static DepartmentDTO toDepartmentDTO(Department department) {
        return new DepartmentDTO(department.getId(), department.getName(), department.getStudents());
    }

}
