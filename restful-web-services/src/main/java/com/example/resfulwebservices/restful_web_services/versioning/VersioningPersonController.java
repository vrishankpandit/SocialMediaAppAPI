package com.example.resfulwebservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping(path = "/v1/person")
	public PersonV1 getVersion1ofPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/v2/person")
	public PersonV2 getVersion2ofPerson() {
		return new PersonV2(new Name("Bob ","Charlie"));
	}
	
	@GetMapping(path = "/person",params="version=1")
	public PersonV1 getVersion1ofPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person",params="version=2")
	public PersonV2 getVersion2ofPersonRequestParameter() {
		return new PersonV2(new Name("Bob ","Charlie"));
	}
	
	@GetMapping(path = "/person/header",headers ="X-API-VERSION=1")
	public PersonV1 getVersion1ofPersonRequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header",headers ="X-API-VERSION=2")
	public PersonV2 getVersion2ofPersonRequestHeader() {
		return new PersonV2(new Name("Bob ","Charlie"));
	}
	
}
	