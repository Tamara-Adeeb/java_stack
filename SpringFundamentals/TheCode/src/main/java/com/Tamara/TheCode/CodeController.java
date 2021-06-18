package com.Tamara.TheCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//can i callback function inside function
@Controller
public class CodeController {
	@RequestMapping("/")
	public String code() {
		return "code.jsp";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public String checkCode(@RequestParam(value = "codeValue") String codeValue,
			RedirectAttributes redirectAttributes) {
		System.out.println(codeValue);
		if (codeValue.equals("Bushido")) {
			System.out.println(codeValue);
			return "currect.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train hurder!");
			return "redirect:/";
		}
	}

	@RequestMapping("/check")
	public String checkCode(
			RedirectAttributes redirectAttributes) {
			redirectAttributes.addFlashAttribute("error2", "You must enter a code");
			return "redirect:/";
		}
}
	


