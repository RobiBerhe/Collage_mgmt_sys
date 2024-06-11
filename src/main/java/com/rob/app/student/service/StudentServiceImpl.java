package com.rob.app.student.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rob.app.department.domain.Department;
import com.rob.app.department.exception.DepartmentNotFoundException;
import com.rob.app.department.repository.DepartmentRepository;
import com.rob.app.student.data.StudentDTO;
import com.rob.app.student.domain.Student;
import com.rob.app.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentServiceImpl(StudentRepository repository, DepartmentRepository departmentRepository) {
        this.studentRepository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO student) {
        Student s = new Student();
        Department d = departmentRepository.findById(student.departmentId())
                .orElseThrow(() -> new DepartmentNotFoundException(student.departmentId()));
        s.setAge(student.age());
        s.setName(student.name());
        s.setLastName(student.lastName());
        s.setDepartment(d);
        studentRepository.save(s);
        return Student.toStudentDTO(s);
    }

    @Override
    public List<StudentDTO> listStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(Student::toStudentDTO)
                .collect(Collectors.toList());
    }

}
