package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
@Configuration
@EnableWebSecurity
//@CrossOrigin(origins= {"http://localhost:3000"})
//@Order(1000)
public class Spring5DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable()   
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .anyRequest().authenticated()
                .and()
            //.formLogin().and()
            .httpBasic();
    }
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("jp").password("jp").roles("Admin");
	}

}
