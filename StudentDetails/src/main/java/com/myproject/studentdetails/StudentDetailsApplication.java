package com.myproject.studentdetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.myproject.studentdetails.dao.StudentRepository;
import com.myproject.studentdetails.models.Student;

@SpringBootApplication
public class StudentDetailsApplication {

	@Autowired
	private StudentRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentDetailsApplication.class, args);
	}

}
