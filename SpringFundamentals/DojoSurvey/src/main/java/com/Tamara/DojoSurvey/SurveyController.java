package com.Tamara.DojoSurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping("/")
	public String surveyForm() {
		return "survey.jsp";
	}

	@RequestMapping("/surveyData")
	public String ProcessData(@RequestParam(value = "name") String name,
			@RequestParam(value = "location") String location, @RequestParam(value = "fav") String fav,
			@RequestParam(value = "comment") String comment,HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("fav", fav);
		session.setAttribute("comment", comment);
		if(fav.equals("java")) {
			return "java.jsp";
		}else {
			return "redirect:/result";
		}
	}
	@RequestMapping("/result")
	public String result(Model model,HttpSession session){
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("location", session.getAttribute("location"));
		model.addAttribute("fav", session.getAttribute("fav"));
		model.addAttribute("comment", session.getAttribute("comment"));
		return "info.jsp";
	}
}
