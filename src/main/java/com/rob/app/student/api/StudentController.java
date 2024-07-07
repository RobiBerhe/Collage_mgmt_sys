package com.rob.app.student.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rob.app.student.data.StudentDTO;
import com.rob.app.student.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<StudentDTO> listStudents() {
        return studentService.listStudents();
    }

    @PostMapping("/add")
    public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createStudent(studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO fetchStudent(@PathVariable (required = true) Long id){
        System.out.println("Path param :> "+id);
        return studentService.getStudentById(id);
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable (required = true) Long id){
        studentService.deleteStudent(id);
        return String.format("Student with an id :%d has successfully been deleted", id);
    }

}
