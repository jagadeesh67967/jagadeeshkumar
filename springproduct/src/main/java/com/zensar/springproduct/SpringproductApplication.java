package com.zensar.springproduct;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringproductApplication {

	public static void main(String... args) {
		SpringApplication.run(SpringproductApplication.class, args);
		
		System.out.println("yogi");
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
