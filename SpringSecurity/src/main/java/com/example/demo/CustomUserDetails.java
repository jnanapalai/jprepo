package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Configuration
public class CustomUserDetails implements UserDetails {
	
	private User user;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		java.util.Set<Role> role=user.getRoles();
		List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
		for(Role r: role)
		{
			System.out.println(r.getRolename());
			list.add(new SimpleGrantedAuthority("ROLE_"+r.getRolename()));
			}
		return list;
		// simp=new SimpleGrantedAuthority()
		// TODO Auto-generated method stub
		//return  user.getRoles().stream().map(role->new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
