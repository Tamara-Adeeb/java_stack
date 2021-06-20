package com.Tamara.NinjaGoldGame;
import java.util.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/gold")
public class GoldController {

	public int countGold = 0;
	public int earnedGold;
	public Date activeCreatedAt = new Date();
	public ArrayList<String> active = new ArrayList<String>();

	@RequestMapping("/")
	public String gold(HttpSession session, Model model) {
		model.addAttribute("countGold", session.getAttribute("gold"));
		return "Gold.jsp";
	}

	@RequestMapping("/countGold")
	public String countGold(HttpSession session, @RequestParam(value = "gold") String gold, Model model) {
		if (gold.equals("Farm")) {
			earnedGold = (int) (Math.random() * 10) + 10;
			countGold += earnedGold;
			System.out.println(gold);
		}
		if (gold.equals("cave")) {
			earnedGold = (int) (Math.random() * 5) + 5;
			countGold += earnedGold;
			System.out.println(gold);
		}

		if (gold.equals("house")) {
			earnedGold = (int) (Math.random() * 3) + 2;
			countGold += earnedGold;
			System.out.println(gold);
		}
		if (gold.equals("casino")) {
			earnedGold = (int) (Math.random() * 100) + (-50);
			countGold += earnedGold;
			System.out.println(gold);
		}
		session.setAttribute("gold", countGold);
		if (earnedGold > 0) {
			active.add("You entered a " + gold + " and earned" + earnedGold + "gold." + activeCreatedAt);
			session.setAttribute(
					"Activities",active);
		} else if (earnedGold < 0) {
			active.add("You entered a " + gold + " and lost" + earnedGold + "gold. Ouch" + activeCreatedAt);
			session.setAttribute("Activities",active);
		} else {
			active.add("You entered a " + gold + " and get nothing '0' " + activeCreatedAt);
			session.setAttribute("Activities", active);
		}

		return "redirect:/";

	}
}
