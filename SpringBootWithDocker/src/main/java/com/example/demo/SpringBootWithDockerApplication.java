package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootWithDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithDockerApplication.class, args);
	}
	@GetMapping("/msg")
public String returnMsg()
{
	return "THis  is spring boot with docker";
}
	
}
