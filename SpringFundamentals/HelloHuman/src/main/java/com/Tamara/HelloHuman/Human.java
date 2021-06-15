package com.Tamara.HelloHuman;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Human {
	@RequestMapping("/")
	public String main(@RequestParam(value="name", required=false) String name) {
		if(name == null)
			return "<h1> Hello Human </h1> <p> Welcome to SpringBoot </p>";
		return "<h1> Hello "+ name+ "</h1> <p> Welcome to SpringBoot </p>";
	}
}
