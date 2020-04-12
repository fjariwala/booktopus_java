package com.bean.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homePage(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		if (session != null) {

			String name = (String) session.getAttribute("name");
			model.addAttribute("user", name);
		} else {

			// session.invalidate();
			// model.addAttribute("user", "");
			System.out.println("Session Ended");
		}

		return "/index";
	}
}
