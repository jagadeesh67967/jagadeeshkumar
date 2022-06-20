package com.zensar.springcoupenproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcoupenprojectApplication extends SpringBootServletInitializer{

	public static void main(String... args) {
		SpringApplication.run(SpringcoupenprojectApplication.class, args);
		
		System.out.println("jagadeesh");
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}

}
