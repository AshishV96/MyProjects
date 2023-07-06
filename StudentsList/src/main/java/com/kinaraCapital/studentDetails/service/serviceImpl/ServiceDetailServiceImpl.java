package com.kinaraCapital.studentDetails.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kinaraCapital.studentDetails.model.Student;

import com.kinaraCapital.studentDetails.repo.StudentDetailsRepository;
import com.kinaraCapital.studentDetails.service.StudentDetailsService;

@Service
public class ServiceDetailServiceImpl implements StudentDetailsService {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository ;
	
	@Override
	public List<Student> getAllDetails(Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
		
//		int pageNumber = 1;
//		int pageSize = 5;
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		
	    Page<Student> pagePost = this.studentDetailsRepository.findAll(p);
		
	    List<Student> contentPost = pagePost.getContent();
	    
		return contentPost;
	}

	@Override
	public List<Student> getStudentByFilterValue(String filter,String value,Integer pageNumber,Integer pageSize) {
		// TODO Auto-generated method stub
		
		Pageable p = PageRequest.of(pageNumber,pageSize);
		int rowCount = 0;
		Page<Student> pageContent = null;
		switch(filter)
		{
			case "city":
			{
				pageContent = this.studentDetailsRepository.findByCity(value,p);
				break;
			}
			case "branch":
			{
				pageContent = this.studentDetailsRepository.findByBranch(value,p);
				break;
			}
			case "age":
			{
				pageContent = this.studentDetailsRepository.findByAge(Integer.parseInt(value),p);
				break;
			}
			case "gender":
			{
				pageContent = this.studentDetailsRepository.findByGender(value,p);
				break;
			}
			case "passoutYear":
			{
				pageContent = this.studentDetailsRepository.findByPassoutYear(Integer.parseInt(value),p);
				break;
			}
			case "experience":
			{
				pageContent = this.studentDetailsRepository.findByExperience(Integer.parseInt(value),p);
				break;
			}
			
		}
				
//		List<StudentDetails> cityPost =  cityPage.getContent();
		    
		return pageContent.getContent();
	}


//	@Override
//	public List<StudentProjection> getDistinctValues(String distinctValue) {
//		// TODO Auto-generated method stub
//		return this.studentDetailsRepository.findByDistinctValues(distinctValue);
//	}

}
