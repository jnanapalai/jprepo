package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin({"http://localhost:3000","http://localhost:8080"})

public class FullStackSpringApplication {

	@Autowired
	EmployeeRepository empRepo;
	public static void main(String[] args) {
		SpringApplication.run(FullStackSpringApplication.class, args);
	}
	@PostMapping("/updateEmp")
	
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp)
	{
		
		return new ResponseEntity(empRepo.save(emp),HttpStatus.OK);
	}
	
	@GetMapping("/getEmpList")
	public ResponseEntity<List<Employee>> getAllEmployee()
	{
		return new ResponseEntity(empRepo.findAll(),HttpStatus.OK);
	}

}
