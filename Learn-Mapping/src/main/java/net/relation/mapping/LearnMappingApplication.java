package net.relation.mapping;

import lombok.extern.flogger.Flogger;
import net.relation.mapping.entity.Laptop;
import net.relation.mapping.entity.Student;
import net.relation.mapping.repository.LaptopRepository;
import net.relation.mapping.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class LearnMappingApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LaptopRepository laptopRepository;

	private Logger logger = LoggerFactory.getLogger(LearnMappingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearnMappingApplication.class, args);
		System.out.println("Learn-Mapping !!!");
	}

	@Override
	public void run(String... args) throws Exception {

		//ONE TO ONE

		Student s1 = new Student();
		s1.setStudentId(150);
		s1.setStudentName("Amit");
		s1.setAbout("Amit is a Dveloper.");

		Laptop l1 = new Laptop();
		l1.setLaptopId(1221);
		l1.setModelNumber("K2EVY456");
		l1.setBrand("Dell");

		l1.setStudent(s1);
//		s1.setLaptops(Stream.of(l1).collect(Collectors.toList()));
		List<Laptop> ll = new ArrayList<>();
		ll.add(new Laptop(1221,"K2EVY456","Dell",s1));
		ll.add(new Laptop(1541,"B5MKY456","Lenovo",s1));
		s1.setLaptops(ll);

		Student savedStudent = studentRepository.save(s1);
//		studentRepository.delete(s1);
//		Laptop savedLaptop = laptopRepository.save(l1);


//		logger.info("Student Name :: {}",savedStudent.getStudentName());
//		logger.info("Laptop Name :: {}",savedLaptop.getBrand());

//		System.out.println("Laptop ID :: "+s1.getLaptop().getLaptopId());
//		System.out.println("Laptop Brand :: "+s1.getLaptop().getBrand());
//		System.out.println("Laptop Model Number :: "+s1.getLaptop().getModelNumber());

//		System.out.println("Student ID :: "+l1.getStudent().getStudentId());
//		System.out.println("Student Name :: "+l1.getStudent().getStudentName());
//		System.out.println("Student Details :: "+l1.getStudent().getAbout());

//		System.out.println("Laptop ID :: "+savedStudent.getLaptop().getLaptopId());
//		System.out.println("Laptop Brand :: "+savedStudent.getLaptop().getBrand());
//		System.out.println("Laptop Model Number :: "+savedStudent.getLaptop().getModelNumber());

//		System.out.println("Student ID :: "+savedLaptop.getStudent().getStudentId());
//		System.out.println("Student Name :: "+savedLaptop.getStudent().getStudentName());
//		System.out.println("Student Details :: "+savedLaptop.getStudent().getAbout());

		System.out.println(studentRepository.getNameAndAbout(150));

	}
}
