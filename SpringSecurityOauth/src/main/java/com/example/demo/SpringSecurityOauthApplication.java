package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthApplication.class, args);
	}
	
	
	
	@GetMapping("/oauth/hello")
	public String getHello()
	{
	return "Hello";
	}
	@GetMapping("ab")
	public String getHello1()
	{
	return "Hello";
	}
	
}
