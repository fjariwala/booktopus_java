package com.bean.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.DAO.Book_DAO;
import com.bean.Entity.BookDetails;

@Controller
public class HomeController {

	/*
	 * Here we need to create Book_DAO's object..... And we will auto wire it ..
	 */
	@Autowired
	private Book_DAO bookDao;

	@GetMapping("/home")
	public String homePage(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		if (session != null) {

			String name = (String) session.getAttribute("name");
			int id = (Integer) session.getAttribute("id");

			model.addAttribute("user", name);

			List<BookDetails> books = bookDao.getBooks(id);
			model.addAttribute("books", books);

		} else {

			// session.invalidate();
			// model.addAttribute("user", "");
			System.out.println("Session Ended");
		}

		return "/index";
	}
}
