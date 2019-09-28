package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRoleRepository extends JpaRepository<User,Integer> {

	//User findByUserName(String username);

	User findByUsername(String username);

}
