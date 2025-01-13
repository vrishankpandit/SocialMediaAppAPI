package com.example.resfulwebservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
	public EntityModel<User> findUserById(@PathVariable int id){
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id:" + id);
		
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).findAllUsers());
		
		EntityModel<User> entityModel=EntityModel.of(user);
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
												.path("/{id}")
												.buildAndExpand(savedUser.getId())
												.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
