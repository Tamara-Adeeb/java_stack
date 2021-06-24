package com.Tamara.License.LicenceController;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Tamara.License.models.Licenses;
import com.Tamara.License.models.Person;
import com.Tamara.License.services.OneToOneService;

@Controller
public class LPController {
	private final OneToOneService oneToOneService;

	public LPController(OneToOneService oneToOneService) {
		this.oneToOneService = oneToOneService;
	}

	@RequestMapping("/persons/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "addPerson.jsp";
	}

	@PostMapping("/addPerson")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "addPerson.jsp";
		}
		this.oneToOneService.createPerson(person);
		return "redirect:/persons/new";
	}
	@GetMapping("/License/new")
	public String addLicense(@ModelAttribute("license") Licenses license,Model model) {
		model.addAttribute("persons", this.oneToOneService.AllPersonWithoutLicense());
		return "addLicense.jsp";
	}
	
	@PostMapping("/addLicense")
	public String addLicense(@ModelAttribute("license") Licenses license,BindingResult result) {
		if (result.hasErrors()) {
			return "addLicense.jsp";
		}
		this.oneToOneService.createLicense(license);
		return "redirect:/License/new";
	}
	@GetMapping("/information")
	public String displayInfo(Model model) {
		model.addAttribute("persons", this.oneToOneService.finaAllPerson());
		model.addAttribute("licenses", this.oneToOneService.findAllLicenses());
		return "information.jsp";
	}
}
