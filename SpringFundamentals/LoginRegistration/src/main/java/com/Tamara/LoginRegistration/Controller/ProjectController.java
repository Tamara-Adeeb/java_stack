package com.Tamara.LoginRegistration.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tamara.LoginRegistration.models.User;
import com.Tamara.LoginRegistration.services.ProjectService;
import com.Tamara.LoginRegistration.validator.UserValidator;

@Controller
public class ProjectController {
	private final ProjectService projectService;
	private final UserValidator userValidator;
	
	public ProjectController(ProjectService projectService, UserValidator userValidator) {
		this.projectService = projectService;
		this.userValidator = userValidator;
	}
	@GetMapping("/")
	public String registerUser(@ModelAttribute("user") User user,HttpSession session) {
		if( session.getAttribute("user_id")!= null ) {
				return "redirect:/home";
			}
		
		return "user.jsp";
	}
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,HttpSession session,Model model) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "user.jsp";
		}
		if(this.projectService.authenticateRegister(user.getEmail())== false) {
			model.addAttribute("error1", "This email is already exist! "); 
			return "user.jsp";
		}
		User registerUser = this.projectService.userRegister(user);
		session.setAttribute("user_id",registerUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if (this.projectService.authenticateUser(email, password)) {
			User user = this.projectService.findByEmail(email);
			session.setAttribute("user_id",user.getId());
			return "redirect:/home";
		}
		
		model.addAttribute("user", new User());
		model.addAttribute("error", "Wrong password or email "); 
		System.out.println(model.getAttribute("error"));
		return "redirect:/";
	}
	
	@GetMapping("/home")
	public  String home(HttpSession session,Model model) {
		if(session.getAttribute("user_id")== null) {
			return "redirect:/";
		}
		Long user_id =  (Long) session.getAttribute("user_id");
		User user = this.projectService.findUserById(user_id);
		model.addAttribute("user", user);
		return "index.jsp";
	}
	
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
	

}
