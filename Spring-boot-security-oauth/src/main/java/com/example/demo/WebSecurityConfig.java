package com.example.demo;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration("WebSecurityConfig")
@EnableWebSecurity
@Order(1000)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	/*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withDefaultPasswordEncoder()
                .username("enduser")
                .password("password")
                .roles("USER")
                .build());
    }*/
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/h2-console/*");
	    return registration;
	}
	/*public void configure(AuthenticationManagerBuilder auth) throws Exception
	{

		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("java1").password("java1").roles("ADMIN","USER").and()
		.withUser("python2").password("python2").roles("USER");
		//auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}*/
	
	

	@Autowired
	private DataSource dataSource;
	
	 @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	 
	 
	 
	 
	 @Bean
		public JdbcTokenStore tokenStore() {
			return new JdbcTokenStore(dataSource);
		}
}
