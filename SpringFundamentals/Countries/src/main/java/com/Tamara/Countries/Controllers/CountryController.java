package com.Tamara.Countries.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Tamara.Countries.services.CountryService;

@Controller
public class CountryController {
	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("first", this.countryService.findSloveneCountries());
		model.addAttribute("second", this.countryService.findNumberOfCitiesInCountry());
//		model.addAttribute("third", this.countryService.findMaxicoPopulation());
		model.addAttribute("fourth", this.countryService.findLungugePersntage());
		model.addAttribute("fifth", this.countryService.findSurfaceArea501());
		model.addAttribute("sixth", this.countryService.findCountryOfConstitutionalMonarchy());
		model.addAttribute("seventh", this.countryService.findCitiesOfArgentina());
		model.addAttribute("eighth", this.countryService.findRegionCountNumber());
		return "index.jsp";
	}
	
}
