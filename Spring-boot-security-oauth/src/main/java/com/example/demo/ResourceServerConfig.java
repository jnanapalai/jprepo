package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
    @Override
	public void configure(HttpSecurity http) throws Exception
	{
    	//http.requestMatchers().antMatchers("/nooauth/hello")
    	//.authenticated().and().formLogin();
    
    	
    	
    	http.csrf().disable();
    	http.authorizeRequests().antMatchers("/h2-console").permitAll();
		//http.requestMatchers().antMatchers("/oauth/hello").and().authorizeRequests().anyRequest().authenticated().and().formLogin().permitAll();
    	http.requestMatchers().antMatchers("/oauth/hello","/console/")
    	.and().authorizeRequests().antMatchers("/oauth/hello","/console/").authenticated().and().formLogin().permitAll();
	}
	
}
