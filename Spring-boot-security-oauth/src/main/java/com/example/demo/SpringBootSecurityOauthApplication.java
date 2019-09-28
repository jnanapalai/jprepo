package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@EnableWebSecurity
public class SpringBootSecurityOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityOauthApplication.class, args);
	}
	
	@GetMapping("/oauth/hello")
	public String getHello()
	{
		return "Hello";
	}
	
	@GetMapping("/nooauth/hello")
	public String getNooauthHello()
	{
		return "Hello No oauth";
	}
	
	 

}
