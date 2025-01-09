package com.example.resfulwebservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId())
												.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
