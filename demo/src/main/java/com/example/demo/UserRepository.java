package com.example.demo;

import org.springframework.context.annotation.Conditional;
import org.springframework.data.jpa.repository.JpaRepository;
@Conditional(VerifyUserRepository.class)
public interface UserRepository extends JpaRepository<User,Integer> {

	User findByName(String name);

}
