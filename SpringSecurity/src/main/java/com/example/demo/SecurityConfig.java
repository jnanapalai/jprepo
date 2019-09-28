package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired	
CustomUserDetailsService userDetailsService;

public void configure(AuthenticationManagerBuilder auth) throws Exception
{

	
	//auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("java1").password("java1").roles("ADMIN","USER").and()
	//.withUser("python2").password("python2").roles("USER");
	auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	
}
	
	public void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable();
	http.authorizeRequests().antMatchers("/rest/welcome").fullyAuthenticated().and().httpBasic()
	.and().formLogin();
http.authorizeRequests().antMatchers("/rest/welcome").hasAnyRole("ADMIN");	

}
}
