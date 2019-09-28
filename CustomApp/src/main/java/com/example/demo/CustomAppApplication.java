package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomAppApplication implements CommandLineRunner {
	@Autowired
	HelloService helloService;

	public static void main(String[] args) {
		SpringApplication.run(CustomAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		helloService.sayHello();
	}
	//@Override
	public void sayHello() {
		System.out.println("CustomHello");
		
	}

}