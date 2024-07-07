package com.rob.app.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rob.app.department.exception.DepartmentNotFoundException;
import com.rob.app.department.repository.DepartmentRepository;
import com.rob.app.student.data.StudentDTO;
import com.rob.app.student.domain.Student;
import com.rob.app.student.exception.StudentNotFoundException;
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
        return departmentRepository.findById(student.departmentId())
            .map(department -> student.toStudent(department))
            .map(studentRepository::save)
            .map(Student::toStudentDTO)
            .orElseThrow(() -> new DepartmentNotFoundException(student.departmentId()));
    }

    @Override
    public List<StudentDTO> listStudents() {
        return studentRepository.findAll().stream().map(Student::toStudentDTO)
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        return studentRepository.findById(id)
            .map(Student::toStudentDTO)
            .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id).
            orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(student.getId());
    }

}
