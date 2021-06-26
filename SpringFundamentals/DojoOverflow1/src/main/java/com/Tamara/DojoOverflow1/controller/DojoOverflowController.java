package com.Tamara.DojoOverflow1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tamara.DojoOverflow1.models.Answer;
import com.Tamara.DojoOverflow1.models.Question;
import com.Tamara.DojoOverflow1.models.Tag;
import com.Tamara.DojoOverflow1.services.DojoOverflowService;

@Controller
public class DojoOverflowController {
	private final DojoOverflowService dojoOverflowService;

	public DojoOverflowController(DojoOverflowService dojoOverflowService) {
		this.dojoOverflowService = dojoOverflowService;
	}
	
	@GetMapping("/questions")
	public String dashboard(Model model) {
		model.addAttribute("questions", this.dojoOverflowService.finaAllQuestions());
		return "questionsDashboard.jsp";
	}
	@GetMapping("/questions/new")
	public String askQuestion(@ModelAttribute("questionToAsk") Question question) {
		return "askQuestion.jsp";
	}
	@PostMapping("/addQuestion")
	public String addQuestion(@Valid @ModelAttribute("questionToAsk") Question question, BindingResult result) {
		if(result.hasErrors()) {
			return "askQuestion.jsp";
		}
		
		System.out.println(question.getTagss());
		String questionTag = question.getTagss();
		String[] ArrayTags = questionTag.split(",");
		for	(String tag:ArrayTags) {
			System.out.println(tag);
		}
		List<Tag> questionTags = new ArrayList();
		for	(String tag:ArrayTags) {
			if(this.dojoOverflowService.isNotCreated(tag)) {
				Tag tagss = this.dojoOverflowService.createTag(tag);
				questionTags.add(tagss);
				
			}else {
			Tag tagss = this.dojoOverflowService.getTag(tag);
			questionTags.add(tagss);
			}
		}
		
		question.setTags(questionTags);
		this.dojoOverflowService.createQuestion(question);
		return"redirect:/questions/new";
	}
	@GetMapping("/question/{id}")
	public String questionAnswer(Model model,@PathVariable("id") Long id) {
		model.addAttribute("question", this.dojoOverflowService.findQustionById(id));
		return "answer.jsp";
	}
	
	@PostMapping("/addAnswer/{id}")
	public String addAnswer(@PathVariable("id") long id, @RequestParam(value="answer") String answer) {
		Question question = this.dojoOverflowService.findQustionById(id);
		Answer qAnswer = new Answer(answer,question);
		this.dojoOverflowService.createAnswer(qAnswer);
		return "redirect:/question/"+id+"";
	}
}
