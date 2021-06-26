package com.Tamara.DojoandNinjas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Tamara.DojoandNinjas.models.Dojo;
import com.Tamara.DojoandNinjas.models.Ninja;
import com.Tamara.DojoandNinjas.services.DojoNinjaService;

@Controller
public class DojoNinjaController {
	private DojoNinjaService dojoNinjaService;
	
	public DojoNinjaController(DojoNinjaService dojoNinjaService) {
		this.dojoNinjaService = dojoNinjaService;
	}
	
	@GetMapping("/dojos/new")
	public String CreateDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	@PostMapping("/addDojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo) {
		this.dojoNinjaService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	@GetMapping("/ninja/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
		List<Dojo> dojos = this.dojoNinjaService.findAllDojos();
		model.addAttribute("dojos", dojos);
		return "ninja.jsp";
	}
	@PostMapping("/addNinja")
	public String createNinja( @ModelAttribute("ninja") Ninja ninja) {
		this.dojoNinjaService.createNinja(ninja);
		return "redirect:/ninja/new";
	}
	@GetMapping("/dojo/{id}")
	public String displayDojoNinjas(@PathVariable("id") Long id,Model model) {
		model.addAttribute("dojo", this.dojoNinjaService.findDojoByid(id));
		return "dojoNinja.jsp";
	}

}
