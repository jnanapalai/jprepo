package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}
	@GetMapping("/welcome")
	public String getWelcome()
	{
		return "Welcome to Microservices 1";
	}
}
