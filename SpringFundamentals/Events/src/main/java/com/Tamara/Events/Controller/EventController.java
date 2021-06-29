package com.Tamara.Events.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Tamara.Events.models.Event;
import com.Tamara.Events.models.User;
import com.Tamara.Events.services.EventsService;
import com.Tamara.Events.validator.EventValidator;
import com.Tamara.Events.validator.UserValidator;

@Controller
public class EventController {
	private final EventsService eventsService;
	private final UserValidator userValidator;
	private final EventValidator eventValidator;
	
	public EventController(EventsService eventsService, UserValidator userValidator, EventValidator eventValidator) {
		this.eventsService = eventsService;
		this.userValidator = userValidator;
		this.eventValidator = eventValidator;
	}
	@GetMapping("/")
	public String addUser(@ModelAttribute("user") User user) {
		return "newUser.jsp";
	}
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result,HttpSession session) {
		this.userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "newUser.jsp";
		}
		User registerUser = this.eventsService.registerUser(user);
		session.setAttribute("user_id",registerUser.getId());
		return "redirect:/events";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if (this.eventsService.authenticateUser(email, password)) {
			User user = this.eventsService.findByEmail(email);
			session.setAttribute("user_id",user.getId());
			return "redirect:/events";
		}
		model.addAttribute("user", new User());
		model.addAttribute("error", "Tamara do not know how "); 
		return "redirect:/";
	}
	@GetMapping("/events")
	public  String home(HttpSession session,Model model,@ModelAttribute("event") Event event) {
		Long user_id =  (Long) session.getAttribute("user_id");
		User user = this.eventsService.findUserById(user_id);
		String[] state = user.getState();
		String userState = state[0];
		System.out.println(state[0]);
		model.addAttribute("stateEvents", this.eventsService.findEventsInMyState(userState));
//		model.addAttribute("stateEvents", this.eventsService.finadEventByState(userState));
		model.addAttribute("notStateEvents", this.eventsService.findEventNotInMyState(userState));
		model.addAttribute("user", user);
		return "home.jsp";
	}
	
	@PostMapping("/addEvent")
	public String addEvent(@Valid @ModelAttribute("event") Event event,BindingResult result) {
		this.eventValidator.validate(event, result);
		if(result.hasErrors()) {
			return "home.jsp";
		}
		this.eventsService.createEvent(event);
		return "redirect:/events";
	}
}
