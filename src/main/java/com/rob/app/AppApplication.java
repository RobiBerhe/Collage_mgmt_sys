package com.rob.app;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rob.app.department.domain.Department;
import com.rob.app.department.repository.DepartmentRepository;
import com.rob.app.student.domain.Student;
import com.rob.app.student.repository.StudentRepository;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
		return args -> {
			Department department = new Department();
			department.setName("Engineering");
			departmentRepository.save(department);
			departmentRepository.findById(department.getId()).orElseThrow(NoSuchElementException::new);

			Student student = new Student();
			student.setName("Abebe");
			student.setLastName("Kebede");
			student.setAge(20);
			student.setDepartment(department);
			studentRepository.save(student);
			studentRepository.findById(student.getId()).orElseThrow(NoSuchElementException::new);
		};
	}

}
