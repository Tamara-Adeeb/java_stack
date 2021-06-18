package com.Tamara.DisplayDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	public int count = 1;// why defined it static
	public int counterByTwo = 0;
	@RequestMapping("")
	public String home(HttpSession session,Model model) {
		counterByTwo = counterByTwo+2;
		session.setAttribute("count", count++);
		session.setAttribute("counterByTwo", counterByTwo);
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String count(HttpSession session,Model model) {
		model.addAttribute("counter", session.getAttribute("count"));
		return "count.jsp";
	}
	@RequestMapping("/rest")
	public String rest(HttpSession session) {
//		session.removeAttribute("count");
//		session.removeAttribute("counterByTwo");
		session.setAttribute("count",0);
		session.setAttribute("counterByTwo",0);
		count=1;
		counterByTwo=0;
		return "redirect:/counter";
	}
}
