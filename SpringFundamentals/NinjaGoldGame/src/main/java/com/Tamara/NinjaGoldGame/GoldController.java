package com.Tamara.NinjaGoldGame;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/gold")
public class GoldController {
	@RequestMapping("/gold")
	public String gold(HttpSession session,Model model) {
		model.addAttribute("countGold", session.getAttribute("gold"));
		return "Gold.jsp";
	}
	@RequestMapping("/countGold")
	public String countGold(HttpSession session, @RequestParam (value="gold") String gold) {
		int countGold = 0;
		System.out.println(gold);
		if(gold == "Farm") {
			countGold += (int) (Math.random()*10)+10;
			System.out.println(gold);
		}
		if(gold == "cave") {
			countGold += (int) (Math.random()*5)+5;
			System.out.println(gold);
		}
		
		if(gold == "house") {
			countGold += (int) (Math.random()*3)+2;
			System.out.println(gold);
		}
		if(gold == "casino") {
			countGold += (int) (Math.random()*100)+(-50);
			System.out.println(gold);
		}
		System.out.println(countGold);
		session.setAttribute("gold", countGold);
		return "redirect:/gold";
		
	}
}
