package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
	

	//@Autowired
	//private CustomAuthenticationManager authenticationManager;
	
	public void configure(HttpSecurity http) throws Exception
	{
		//http.authorizeRequests().anyRequest().permitAll().antMatchers("/oauth/hello").fullyAuthenticated();
		http.
		anonymous().disable()
		.requestMatchers().antMatchers("/oauth/**")
		.and().authorizeRequests()
		.antMatchers("/oauth/**").access("hasRole('ROLE_ADMIN')");
	}
/*	@Autowired
public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication().withUser("scott").password("tiger")
	    .roles("Admin");
	}*/
	
	/*@Bean
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
	    builder.inMemoryAuthentication().withUser("scott").password("tiger")
	    .roles("Admin");
	}*/
	
	/*public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.parentAuthenticationManager(authenticationManager)
		.inMemoryAuthentication().withUser("Peter")
		.password("Peter")
		.roles("Admin");
	}*/
}
