package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/rest")
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String getHelloWorldMessag()
	{
		return "HelloWorld";
	}
	//@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping("/welcome")
	public String getWelcomeMessage()
	{
		return "Welcome";
		
		
	}
}
