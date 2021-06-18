package com.Tamara.DisplayDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controler {
	@RequestMapping("")
	public String home() {
		return"index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat local = new SimpleDateFormat("dd/MM/yyyy");
		String currentDate = local.format(new Date());
		model.addAttribute("CurrentDate", currentDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat local = new SimpleDateFormat("hh:mm:ss aa");
		String currentTime = local.format(new Date());
		model.addAttribute("CurrentTime", currentTime);
		return "time.jsp";
	}


}
