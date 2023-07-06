package com.myproject.studentdetails.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.studentdetails.models.Student;

@Service
public interface StudentService {

	public List<Student> getAllPageWise(int pageNo,int pageSize);
	
}
