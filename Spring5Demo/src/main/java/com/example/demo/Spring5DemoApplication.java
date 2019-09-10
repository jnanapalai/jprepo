package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Spring5DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5DemoApplication.class, args);
	}
	
	@Bean
	RouterFunction<?> router()
	{
		RouterFunctions.route(RequestPredicates.GET("/hello"),request->null);
	}

}
@Component
class HelloHandler
{
	public Response<String> getHello(Request request){}
}