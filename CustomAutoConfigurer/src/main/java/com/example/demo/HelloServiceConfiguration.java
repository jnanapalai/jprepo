package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
public class HelloServiceConfiguration {
	@Bean
	@ConditionalOnMissingBean
	public HelloService helloService()
	{
		return new HelloServiceImpl();
	}

}
