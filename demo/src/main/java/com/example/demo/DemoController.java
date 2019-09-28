package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


interface B
{
	public void show();
}
@RestController
public class DemoController {
	
	@Autowired(required=false)
	
	UserRepository userRepository;
	//@Value("$(spring.application.name)")
	@Value("${spring.application.name}")
	private String name;
	
	
	@GetMapping("/home")
	public String homePage()
	{
		System.out.println(name);
		B b=()->{
			System.out.println("Hello");
		};
		b.show();
		return "Welcome to Home page";
	}
	@GetMapping("/userdtls")
	public List<User> getUserDetails()
	{
	List<User> user=userRepository.findAll();
	return user;
	}
	@GetMapping("/userdtlsbyid/{id}")
	/*public Resource<User> getUserById(@PathVariable int  id)
	{
		Optional<User> user=userRepository.findById(id);
		if(!user.isPresent())
		{
			throw new DemoCusotmException("User Not Found"+id);
		}
		
		//Resource<User> resource = new Resource<User>(User.get());

	    ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getUserDetails());

	    resource.add(linkTo.withRel("all-students"));

	    return resource;
		return user;
	}*/
	private Object methodOn(Class<? extends DemoController> class1) {
		// TODO Auto-generated method stub
		return null;
	}
	@PostMapping("/insertUser")
	public void  insertUser(@RequestBody User user)
	{
		System.out.println(user.getId()+"And"+user.getName());
		userRepository.save(user);
	}
	@PostMapping("/insertUserBulk")
	public void insertUserBulk(@RequestBody List<User> user)
	{
		for (User u:user)
		{
			userRepository.save(u);
		}
		//userRepository.saveAll(user);
	}
	@GetMapping("findByName/{name}/{abc}")
	public User getByName(@PathVariable("name") String name,@PathVariable("abc") String abc)
	{
		System.out.println(abc);
		return userRepository.findByName(name);
	}

}
