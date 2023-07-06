package com.kinaraCapital.studentDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kinaraCapital.studentDetails.model.Student;

import com.kinaraCapital.studentDetails.service.StudentDetailsService;

@RestController
@RequestMapping("api")
public class StudentDetailsController {
	
	@Autowired
	private StudentDetailsService studentDetailsService;
	
	@GetMapping("/details")
	public ResponseEntity<List<Student>> getAllDetails(
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
	
	{
	  ResponseEntity<List<Student>> re = null;
	  
	  List<Student> detailedList = this.studentDetailsService.getAllDetails(pageNumber, pageSize);
	  if(detailedList.isEmpty())
	  {
		  re= new ResponseEntity<List<Student>>(detailedList,HttpStatus.NOT_FOUND);
	  }else
	  {
		  re= new ResponseEntity<List<Student>>(detailedList,HttpStatus.OK);
	  }
		return re;	
	}

	
	@GetMapping("/{filter}/{value}")
	public ResponseEntity<List<Student>> getALLStudentByFilterValue(@PathVariable("filter") String filter,@PathVariable("value") String value,
			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
	{
		ResponseEntity<List<Student>> re = null;
		
		List<Student> filterList = this.studentDetailsService.getStudentByFilterValue(filter,value,pageNumber, pageSize );
		
		if(filterList.isEmpty())
		{
			re = new ResponseEntity<List<Student>>(filterList,HttpStatus.NOT_FOUND);
			
		}else
		{
			re = new ResponseEntity<List<Student>>(filterList,HttpStatus.OK);
		}
		return re;
		
	}
	
//	@GetMapping("/branch/{branch}")
//	public ResponseEntity<List<StudentDetails>> getALLStudentOfSameBranch(@PathVariable("branch") String branch,
//			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
//	{
//		ResponseEntity<List<StudentDetails>> re = null;
//		
//		List<StudentDetails> branchList = this.studentDetailsService.getStudentByBranch(branch,pageNumber, pageSize );
//		
//		if(branchList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentDetails>>(branchList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentDetails>>(branchList,HttpStatus.OK);
//		}
//		return re;
//		
//	}
//	
//	@GetMapping("/age/{age}")
//	public ResponseEntity<List<StudentDetails>> getALLStudentOfSameAge(@PathVariable("age") int age,
//			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
//	{
//		ResponseEntity<List<StudentDetails>> re = null;
//		
//		List<StudentDetails> ageList = this.studentDetailsService.getStudentByAge(age,pageNumber, pageSize );
//		
//		if(ageList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentDetails>>(ageList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentDetails>>(ageList,HttpStatus.OK);
//		}
//		return re;
//		
//	}
//	
//	@GetMapping("/gender/{gender}")
//	public ResponseEntity<List<StudentDetails>> getALLStudentOfSameGender(@PathVariable("gender") String gender,
//			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
//	{
//		ResponseEntity<List<StudentDetails>> re = null;
//		
//		List<StudentDetails> genderList = this.studentDetailsService.getStudentByGender(gender,pageNumber, pageSize );
//		
//		if(genderList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentDetails>>(genderList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentDetails>>(genderList,HttpStatus.OK);
//		}
//		return re;
//		
//	}
//	
//	@GetMapping("/passoutYear/{passOutYear}")
//	public ResponseEntity<List<StudentDetails>> getALLStudentOfSamePassoutYear(@PathVariable("passOutYear") int passOutYear,
//			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
//	{
//		ResponseEntity<List<StudentDetails>> re = null;
//		
//		List<StudentDetails> yearList = this.studentDetailsService.getStudentByPassoutYear(passOutYear,pageNumber, pageSize );
//		
//		if(yearList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentDetails>>(yearList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentDetails>>(yearList,HttpStatus.OK);
//		}
//		return re;
//		
//	}
//	
//	@GetMapping("/experience/{experience}")
//	public ResponseEntity<List<StudentDetails>> getALLStudentOfSameExperience(@PathVariable("experience") int experience,
//			@RequestParam(value = "pageNumber",defaultValue = "0",required = false) Integer pageNumber,
//            @RequestParam(value = "pageSize",defaultValue = "10",required = false) Integer pageSize)
//	{
//		ResponseEntity<List<StudentDetails>> re = null;
//		
//		List<StudentDetails> experienceList = this.studentDetailsService.getStudentByExperience(experience,pageNumber, pageSize );
//		
//		if(experienceList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentDetails>>(experienceList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentDetails>>(experienceList,HttpStatus.OK);
//		}
//		return re;	
//	}
	
//	@GetMapping("/distinct/{param}")
//	public ResponseEntity<List<StudentProjection>> getDistinctValues(@PathVariable("param") String distinctValue) {
//		// TODO Auto-generated method stub
//		
//		ResponseEntity<List<StudentProjection>> re = null;
//		
//		List<StudentProjection> distinctList =this.studentDetailsService.getDistinctValues(distinctValue);
//		
//		if(distinctList.isEmpty())
//		{
//			re = new ResponseEntity<List<StudentProjection>>(distinctList,HttpStatus.NOT_FOUND);
//		}else
//		{
//			re = new ResponseEntity<List<StudentProjection>>(distinctList,HttpStatus.OK);
//		}
//		return re;	
//	}
}
