package com.zensar.springcoupenproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringcoupenprojectApplication {

	public static void main(String... args) {
		SpringApplication.run(SpringcoupenprojectApplication.class, args);
		
		System.out.println("jagadeesh");
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();

	}

}
