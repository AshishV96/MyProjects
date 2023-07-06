package com.myproject.studentdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.studentdetails.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
