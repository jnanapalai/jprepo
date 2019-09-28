package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class DemoEurekaClientApplication {
	
	@Autowired
	DiscoveryClient client;
	
	RestTemplate template=new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaClientApplication.class, args);
	}
	@GetMapping("/emp")
	public Employee getEmployee()
	{
		
		
		java.util.List<ServiceInstance> listOfinstances=client.getInstances("demos");
		System.out.println("List is"+listOfinstances);
		ServiceInstance instance=listOfinstances.get(0);
		String baseUri="http://localhost:7002";
		baseUri=baseUri+"/getEmployee";
		return template.getForObject(baseUri,Employee.class);
		
	}

}
