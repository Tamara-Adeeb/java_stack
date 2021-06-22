package com.Tamara.Languages.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Tamara.Languages.models.Language;
import com.Tamara.Languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/languages")
	public String displyLanguages(Model model) {
		model.addAttribute("all_Languages", this.languageService.allLanguages());
		model.addAttribute("language", new Language());
		return "display.jsp";
	}
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createLanguage(@Valid @ModelAttribute("language")Language language,BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/languages";
		}
		this.languageService.createLanguage(language);
		return "redirect:/languages/"+(language.getId()).toString();
}
	@RequestMapping("/languages/edit/{id}")
public String edit(@PathVariable("id") Long id, Model model) {
		Language language = this.languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
}
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("language") Language language) {
//		this.languageService.updateLanguage(this.languageService.findLanguage(language.getId()));
//		Language updatedLanguage = this.languageService.findLanguage(id);
		this.languageService.updateLanguage(language);
		return "redirect:/languages/edit/"+(language.getId()).toString() ;
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		model.addAttribute("language", this.languageService.findLanguage(id));
		return "show.jsp";
	}
}
