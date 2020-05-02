package com.bean.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.DAO.Book_DAO;
import com.bean.Entity.BookDetails;
import com.bean.Hashing.SessionGetter;

@Controller
@RequestMapping("/book")
public class Book_Controller {

	/*
	 * Here we need to create Book_DAO's object..... And we will auto wire it ..
	 */
	@Autowired
	private Book_DAO bookDao;

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

	@PostMapping("/uploadBook")
	public String testUpload(@RequestParam("fileUpload") MultipartFile file,
			@ModelAttribute("book") BookDetails bookData) {

		String returnValue = null;
//		if (theBindedResults.hasErrors()) {
//
//			System.out.println(theBindedResults.getFieldErrorCount());
//			returnValue = "/books/bookForm";
//
//		} else {

		try {
			String result = bookDao.saveBook(bookData, file);
			if (result != null) {
				returnValue = "redirect:/home";

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			returnValue = "redirect:/book/uploadBook";
		}
		// }
		return returnValue;

	}

	@GetMapping("/getBookData")
	public String getBook(@RequestParam("bookId") int bookId, Model model, HttpServletRequest req) {

		// HttpSession session = req.getSession(false);

		SessionGetter sessionData = new SessionGetter();

		String userName = sessionData.sessionGetter(req);

		if (userName != null) {

			// String userName = (String) session.getAttribute("name");

			model.addAttribute("user", userName);

			BookDetails bookData = bookDao.getIndividualBook(bookId);
			System.out.println(bookData);

			model.addAttribute("book", bookData);

			return "/books/bookPage";

		} else {

			// session.invalidate();
			// model.addAttribute("user", "");
			System.out.println("Session Ended");
			return "redirect:/home";
		}

	}

	@PostMapping("/search")
	public String searchBooks(@RequestParam("strVal") String regStr, HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);
		String returnStr = null;

		if (session != null) {

			int userId = (Integer) session.getAttribute("id");
			String userName = (String) session.getAttribute("name");

			List<BookDetails> searchedBooks = bookDao.searchBooks(regStr, userId);

			if (searchedBooks.isEmpty()) {

				System.out.println("No data");
				model.addAttribute("user", userName);
				model.addAttribute("books", null);
				returnStr = "/index";
			} else {
//				for (BookDetails bookDetails : searchedBooks) {
//					System.out.println(bookDetails);
//				}
				model.addAttribute("user", userName);
				model.addAttribute("books", searchedBooks);
				returnStr = "/index";
			}

		}
		return returnStr;
	}

}
