package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
@Bean
//Imported ModelMapper class - Which we inserted as a dependancy in pom.xml
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}
