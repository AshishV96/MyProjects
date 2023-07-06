package com.kinaraCapital.studentDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kinaraCapital.studentDetails.repo.StudentDetailsRepository;

@SpringBootApplication
public class KinaraCapitalAssingmentApplication implements CommandLineRunner {

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(KinaraCapitalAssingmentApplication.class, args);
		
		System.out.println("Application started");
		
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET","POST","PUT","DELETE");
			}
		};
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int rowCount = this.studentDetailsRepository.countByCity("nagpur");
		System.out.println(rowCount);
		
		System.out.println(this.studentDetailsRepository.count());
	}
	
	

}
 