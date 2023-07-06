package com.myproject.studentdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.studentdetails.models.Student;
import com.myproject.studentdetails.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllbyPage(@RequestParam(name = "pageNo",required = false,defaultValue = "0") int pageNo , @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize)
	{
		ResponseEntity<List<Student>> re;
		
		List<Student> students = service.getAllPageWise(pageNo, pageSize);
		
		if(students.isEmpty())
		{
			re = new ResponseEntity<List<Student>>(students, HttpStatus.NOT_FOUND);
		}
		
		else
		{
			re = new ResponseEntity<List<Student>>(students, HttpStatus.OK);
		}
		
		return re;
	}
}
