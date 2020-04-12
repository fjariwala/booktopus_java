package com.bean.Controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Entity.BookDetails;

@Controller
@RequestMapping("/book")
public class Book_Controller {

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

	@GetMapping("/uploadBook")
	public String showBookForm(Model model, HttpServletRequest req) {

		model.addAttribute("book", new BookDetails());

		HttpSession session = req.getSession(false);
		if (session != null) {

			int id = (Integer) session.getAttribute("id");
			model.addAttribute("id", id);
		}

		return "/books/bookForm";
	}

}
