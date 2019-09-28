package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OauthServerJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServerJwtApplication.class, args);
	}
	@GetMapping("/getAuthCode")
	public void getAuthCode(@RequestParam(name = "code") String code)
	{
		System.out.println("The code is"+code);
	}
	
	@GetMapping("/getAuthCode1")
	public void getAuthCode1(@RequestParam(name = "code") String code)
	{
		System.out.println("The code is"+code);
	}

}
