package com.example.resfulwebservices.restful_web_services.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		this.messageSource=messageSource;
	}
	
	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello-World";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("HelloWorld");
	}
	
	@GetMapping(path="hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name) {
		return new HelloWorldBean(String.format("HelloWorld %s",name));
	}
	
	@GetMapping(path="/hello-world-internalization")
	public String helloWorldinternalization() {
		
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
//		return "Hello-World-V2";
	}
}
