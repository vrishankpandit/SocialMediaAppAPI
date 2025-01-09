package com.example.resfulwebservices.restful_web_services.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	private UserDAOService service;
	
	public UserResource(UserDAOService service) {
		super();
		this.service=service;
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return service.findAll();
	}
}
