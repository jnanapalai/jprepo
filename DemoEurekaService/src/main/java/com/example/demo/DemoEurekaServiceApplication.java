package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient
@RestController
public class DemoEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaServiceApplication.class, args);
	}
	@GetMapping("/getEmp")
	public Employee getEmployee()
	{
		Employee e=new Employee(1,"ABC");
		return e;
	}

}
