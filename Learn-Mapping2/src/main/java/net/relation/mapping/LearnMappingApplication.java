package net.relation.mapping;

import net.relation.mapping.entity.Address;
import net.relation.mapping.entity.Catagory;
import net.relation.mapping.entity.Product;
import net.relation.mapping.entity.Student;
import net.relation.mapping.repository.CatagoryRepository;
import net.relation.mapping.repository.LaptopRepository;
import net.relation.mapping.repository.ProductRepository;
import net.relation.mapping.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class LearnMappingApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private LaptopRepository laptopRepository;
	@Autowired
	private CatagoryRepository catagoryRepository;
	@Autowired
	private ProductRepository productRepository;

	private Logger logger = LoggerFactory.getLogger(LearnMappingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LearnMappingApplication.class, args);
		System.out.println("Learn-Mapping !!!");
	}

	@Override
	public void run(String... args) throws Exception {

		//ONE TO ONE

//		Student s1 = new Student();
//		s1.setStudentId(111);
//		s1.setStudentName("Amit");
//		s1.setAbout("Amit is a Dveloper.");
//
//		Laptop l1 = new Laptop();
//		l1.setLaptopId(1111);
//		l1.setModelNumber("K2EVY456");
//		l1.setBrand("Dell");
//
//		l1.setStudent(s1);
//		s1.setLaptop(l1);
//
//		Student savedStudent = studentRepository.save(s1);
//		Laptop savedLaptop = laptopRepository.save(l1);
//
//
//		logger.info("Student Name :: {}",savedStudent.getStudentName());
//		logger.info("Laptop Name :: {}",savedLaptop.getBrand());

		//studentRepository.delete(s1);

//		System.out.println("Laptop ID :: "+s1.getLaptop().getLaptopId());
//		System.out.println("Laptop Brand :: "+s1.getLaptop().getBrand());
//		System.out.println("Laptop Model Number :: "+s1.getLaptop().getModelNumber());
//
//		System.out.println("Student ID :: "+l1.getStudent().getStudentId());
//		System.out.println("Student Name :: "+l1.getStudent().getStudentName());
//		System.out.println("Student Details :: "+l1.getStudent().getAbout());
//
//		System.out.println("Laptop ID :: "+savedStudent.getLaptop().getLaptopId());
//		System.out.println("Laptop Brand :: "+savedStudent.getLaptop().getBrand());
//		System.out.println("Laptop Model Number :: "+savedStudent.getLaptop().getModelNumber());
//
//		System.out.println("Student ID :: "+savedLaptop.getStudent().getStudentId());
//		System.out.println("Student Name :: "+savedLaptop.getStudent().getStudentName());
//		System.out.println("Student Details :: "+savedLaptop.getStudent().getAbout());

		//ONE TO MANY

//		Student s2 = new Student();
//		s2.setStudentId(222);
//		s2.setStudentName("Roshan");
//		s2.setAbout("Roshan is an Data Analyst.");
//
//		Address a1 = new Address();
//		a1.setAddressId(999);
//		a1.setStreet("19th Cross");
//		a1.setCity("Noida");
//		a1.setCountry("INDIA");
//		a1.setStudent(s2);
//
//		Address a2 = new Address();
//		a2.setAddressId(888);
//		a2.setStreet("91th Cross");
//		a2.setCity("Delhi");
//		a2.setCountry("INDIA");
//		a2.setStudent(s2);
//
//		List<Address> addressList = new ArrayList<>();
//		addressList.add(a1);
//		addressList.add(a2);
//
//		s2.setAddressList(addressList);
//
//		Student save = studentRepository.save(s2);
//
//		logger.info("Student Created :: With Address ");

		//MANY TO MANY

		Product product1 = new Product();
		product1.setpId("pid1");
		product1.setProductName("IPhone 14 Max Pro");

		Product product2 = new Product();
		product2.setpId("pid2");
		product2.setProductName("Samsung S22 Ultra");

		Product product3 = new Product();
		product3.setpId("pid3");
		product3.setProductName("SamsungTV123451");

		Catagory catagory1 = new Catagory();
		catagory1.setcId("cid1");
		catagory1.setTitle("Electronics");

		Catagory catagory2 = new Catagory();
		catagory2.setcId("cid2");
		catagory2.setTitle("Mobile Phone");

		List<Product> catagory1Products = catagory1.getProducts();
		catagory1Products.add(product1);
		catagory1Products.add(product2);
		catagory1Products.add(product3);

		List<Product> catagory2Products = catagory2.getProducts();
		catagory2Products.add(product1);
		catagory2Products.add(product2);

//		product1.getCatagories().add(catagory1);
//		product1.getCatagories().add(catagory2);
//
//		product2.getCatagories().add(catagory1);
//		product2.getCatagories().add(catagory2);
//
//		product3.getCatagories().add(catagory1);

		catagoryRepository.save(catagory1);
		catagoryRepository.save(catagory2);

//		productRepository.save(product1);
//		productRepository.save(product2);
//		productRepository.save(product3);

//		Catagory catagory = catagoryRepository.findById("cid1").get();
//		System.out.println("HELLO ARVIND :: This catagory contains "+catagory.getProducts().size()+" Products");
//
//		Product product = productRepository.findById("pid1").get();
//		System.out.println("HELLO ARVIND :: It comes under "+product.getCatagories().size()+" Catagories.");

//		System.out.println(product.getCatagories());
	}
}
