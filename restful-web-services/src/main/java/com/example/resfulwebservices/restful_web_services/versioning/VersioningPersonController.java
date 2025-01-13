package com.example.resfulwebservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping(path = "/v1/person")
	public PersonV1 getFirstVersion1ofPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/v2/person")
	public PersonV2 getFirstVersion2ofPerson() {
		return new PersonV2(new Name("Bob ","Charlie"));
	}
}
	