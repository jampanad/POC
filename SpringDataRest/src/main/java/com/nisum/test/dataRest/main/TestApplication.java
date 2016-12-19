package com.nisum.test.dataRest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.nisum.test.dataRest.dao.StudentRepo;


public class TestApplication extends SpringBootServletInitializer {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(StudentRepo.class);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StudentRepo.class, args);
	}

}
