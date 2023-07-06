package com.myproject.studentdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myproject.studentdetails.dao.StudentRepository;
import com.myproject.studentdetails.models.Student;

@Service
public class StudentServiceImplementaion implements StudentService {

	@Autowired
	private StudentRepository repo;
	
	public List<Student> getAllPageWise(int pageNo,int pageSize)
	{
	
		Pageable p = PageRequest.of(pageNo, pageSize);
		
		Page<Student> page = repo.findAll(p);
		
		List<Student> students = page.getContent();
		
		return students;
		
	}	
}
