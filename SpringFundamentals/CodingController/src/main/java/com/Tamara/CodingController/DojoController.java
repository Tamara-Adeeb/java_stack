package com.Tamara.CodingController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
//	@RequestMapping("/{dojo}")
//	public String dojo(@PathVariable ("dojo") String dojo) {
//		return "The "+dojo+" is awesome!";
//	}
//	@RequestMapping("/{dojo}/{burbank-dojo}")
//	public String burbankDojo(@PathVariable ("dojo") String dojo,@PathVariable ("burbank-dojo") String burbankdojo) {
//		return burbankdojo+" is located in Southern California";
//	}
//	@RequestMapping("/{dojo}/{burbank-dojo}/{san-jose}")
//	public String sanJose(@PathVariable ("dojo") String dojo,@PathVariable ("burbank-dojo") String burbankdojo,@PathVariable ("san-jose") String sanjose) {
//		return sanjose + " dojo is the headquarters";
//	}
	@RequestMapping("/{name}")
	public String dojo(@PathVariable ("name") String name) {
		if(name == "dojo") {
			return "The dojo is awesome!";
		}
		else if(name == "burbank-dojo") {
			return "Burbank Dojo is located in Southern California";
		}
		else if(name == "san-jose") {
			return "SJ dojo is the headquarters";
		}
		return "you have to enter doj or burbank-dojo or san-jose";
	}

	
	
	
	
}
