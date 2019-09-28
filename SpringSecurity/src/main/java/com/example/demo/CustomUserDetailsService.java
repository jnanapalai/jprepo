package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
@Configuration
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user= userRoleRepository.findByUsername(username);
		
		CustomUserDetails customUserDetails=new CustomUserDetails();
		customUserDetails.setUser(user);
		return customUserDetails;
	}

}
