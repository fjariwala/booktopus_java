package com.bean.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/go")
	public String newPage() {
		return "/demo";
	}
}
