package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityExampleApplication.class, args);
	}
	@GetMapping("/hello")
	public String getHello()
	{
		return "Hello";
	}
	
	@GetMapping("/hello1")
	public String getHello1()
	{
		return "Hello1";
	}

}
