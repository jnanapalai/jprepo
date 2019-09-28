package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
/*@Bean
public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
	    builder.inMemoryAuthentication().withUser("scott").password("tiger")
	    .roles("Admin");
	}*/

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.checkTokenAccess("isAuthenitcated()").passwordEncoder(NoOpPasswordEncoder.getInstance());
		
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		
	
		clients.inMemory().withClient("scott")
		.authorizedGrantTypes("client-credentials", "password","refresh_token")
		.authorities("ROLE_Admin")
		.scopes("read", "write", "trust")
		.secret("tiger").accessTokenValiditySeconds(10000)
		.refreshTokenValiditySeconds(50000);
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//endpoints.authenticationManager(authenticationManager);
		endpoints.authenticationManager(authenticationManager);
		
	

	}
	

}
