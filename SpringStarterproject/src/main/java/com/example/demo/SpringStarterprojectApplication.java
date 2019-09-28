package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SpringStarterprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarterprojectApplication.class, args);
	}

	@Scheduled(initialDelay=1000,fixedRate=10000)
	public void run()
	{
		System.out.println("Inside Schedular");
	}
	
	@Bean
	public FilterRegistrationBean<JerseyAuthenitcationFilter> loggingFilter(){
	    FilterRegistrationBean<JerseyAuthenitcationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new JerseyAuthenitcationFilter());
	   // registrationBean.addUrlPatterns("/task/*");
	         
	    return registrationBean;    
	}
	
}

