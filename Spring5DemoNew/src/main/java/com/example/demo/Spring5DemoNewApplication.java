package com.example.demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.xml.ws.Response;

//import org.junit.platform.commons.logging.LoggerFactory;
//import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
//@EnableWebFlux
@CrossOrigin(origins= {"http://localhost:3000"})

public class Spring5DemoNewApplication extends SpringBootServletInitializer {
	@Autowired
	StudentRepository studRepo;
	
	
	//Logger log=(Logger) LoggerFactory.getLogger(Spring5DemoNewApplication.class);
	
	@Value("${sqs.url}")
	private String sqsURL;
	
	@GetMapping("/getStudent")
	public List<Student> getStudent()
	{
		AmazonSQS sqs=AmazonSQSClientBuilder.defaultClient();
		//AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				//  .withCredentials(new AWSStaticCredentialsProvider(credentials))
				  //.withRegion(Regions.US_EAST_1)
				  //.build();
		
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<>();
		messageAttributes.put("AttributeOne", new MessageAttributeValue()
		  .withStringValue("This is an attribute")
		  .withDataType("String"));  
		     
		SendMessageRequest sendMessageStandardQueue = new SendMessageRequest()
		  .withQueueUrl(sqsURL)
		  .withMessageBody("A simple message.")
		  .withDelaySeconds(30)
		  .withMessageAttributes(messageAttributes);
		 
		sqs.sendMessage(sendMessageStandardQueue);
		return studRepo.findAll();
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student)
	{
		System.out.println("Student data is"+student.getId()+student.getName()+student.getMark());
		
		return new ResponseEntity(studRepo.save(student),HttpStatus.OK);
		
	}
	
	
	@Autowired
	EmployeeRepository employeeRepo;
	@GetMapping("/createEmp")
	public void createEmployee()
	{
		Employee e1=new Employee();
		e1.setId(51);e1.setName("Priyasha");;
		employeeRepo.save(e1);
	}
	@GetMapping("/getE")
	public List<Employee> getEmp()
	{
		return employeeRepo.findAll();
	}
	
	@GetMapping(value="/getEmp",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<List<Employee>> getEmployee()
	{
		//return Flux.just(employeeRepo.findAll());
		return Flux.fromStream(Stream.generate(()->employeeRepo.findAll())).delayElements(Duration.ofSeconds(5));
		//Flux.zip(combinator, sources)
		//return employeeRepo.findAll();
	}
	
	@Bean
	RouterFunction<?> route(HelloHandler handler)
	{
		return RouterFunctions.route(RequestPredicates.GET("/hello"),handler::getHello)
				.and(RouterFunctions.route(RequestPredicates.GET("/Person"),handler::getPerson));
	}

	public static void main(String[] args) {
		SpringApplication.run(Spring5DemoNewApplication.class, args);
	}

}

class Person
{
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	String name;
}

@Component
class HelloHandler
{
	Mono<ServerResponse> getHello(ServerRequest request)
	{
		Person p=new Person();
		p.setId(1);p.setName("EMP");
		System.out.println("Hello");
		return ServerResponse.ok().body(BodyInserters.fromPublisher(Mono.just("Hello"), String.class));
		//return Mono.just("Hello");
	}
	Mono<ServerResponse> getPerson(ServerRequest request)
	{
		Person p=new Person();
		p.setId(1);p.setName("EMP");
		return ServerResponse.ok().body(BodyInserters.fromPublisher(Mono.just(p),Person.class));
	}
}
