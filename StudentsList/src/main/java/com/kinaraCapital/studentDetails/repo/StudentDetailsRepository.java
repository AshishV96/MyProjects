package com.kinaraCapital.studentDetails.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kinaraCapital.studentDetails.model.Student;


public interface StudentDetailsRepository extends JpaRepository<Student, Integer> {

	
	Page<Student> findByCity(String city,Pageable p);
	
	int countByCity(String city);

	Page<Student> findByBranch(String branch,Pageable p);

	int countByBranch(String branch);
	
	Page<Student> findByAge(int age,Pageable p);

	int countByAge(String age);
	
	Page<Student> findByGender(String gender,Pageable p);
	
	int countByGender(String gender);
	
	Page<Student> findByPassoutYear(int passoutYear,Pageable p);

	int countByPassoutYear(String passoutYear);
	
	Page<Student> findByExperience(int experience,Pageable p);
    
	int countByExperience(String experience);
	
////	@Query(value="select Distinct s.city as stringList from student_details as s",nativeQuery = true)
////	List<StudentProjection> findByDistinctValues(String Stringvalue);
//	
//	@Query(value = "SELECT DISTINCT ?1 AS stringList FROM student_details as", nativeQuery = true)
//    List<StudentProjection> findByDistinctValues(String column);
	
	//List<StudentProjection> findByDistinctValues();
	
	

	



}
