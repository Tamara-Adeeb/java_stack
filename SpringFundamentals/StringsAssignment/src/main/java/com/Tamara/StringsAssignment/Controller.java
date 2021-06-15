package com.Tamara.StringsAssignment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping("/")
	public String home() {
		return "Hello client! Welcome Home!";
	}

	@RequestMapping("/random")
	public String random() {
		return "Spring Boot is great";
	}
}
