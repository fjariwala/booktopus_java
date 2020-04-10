package com.bean.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.DAO.User_DAO;
import com.bean.Entity.UserDetails;

@Controller
@RequestMapping("/user")
public class LoginANDRegister_Controller {

	@Autowired
	private User_DAO userDao;

	/*
	 * We use @InitBinder annotation to remove front and back white spaces. How it
	 * is gonna work? All the requests(data) coming to '/student' controller will be
	 * trimmed using this method
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		// true means if there are all the white spaces , StringTrimmerEditor class will
		// trim it down to null

		dataBinder.registerCustomEditor(String.class, trimmer);
	}

	/* GET method for register form */
	@GetMapping("/register")
	public String register(Model model) {

		UserDetails user = new UserDetails();
		model.addAttribute("user", user);

		return "/auth/register";
	}

	/* POST mapping for registering the user form */
	@PostMapping("/register")
	public String saveUserData(@Valid @ModelAttribute("user") UserDetails user, BindingResult resultBinded,
			Model model) {

		if (resultBinded.hasErrors()) {
			return "/auth/register";
		} else {
			/* SAve the user */
			// System.out.println(user.toString());

			/* 1) we will check wheather the user is registered or not */
			Boolean res = userDao.checkUser(user);

			if (res == true) {
				model.addAttribute("error",
						"The user already exists with current email id, try again with another email.");
				return "/auth/register";
			} else {

				String result = userDao.registerUser(user);
			}

			return "demo";
		}

	}
}
