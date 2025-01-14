package com.example.resfulwebservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping(path="/filtering")
	private SomeBean filtering() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping(path="/filtering-list")
	private List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value4","value5","value6"));
	}
}
