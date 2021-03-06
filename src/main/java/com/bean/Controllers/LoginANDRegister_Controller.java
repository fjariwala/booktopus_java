package com.bean.Controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.bean.DAO.Book_DAO;
import com.bean.DAO.Notification_DAO;
import com.bean.DAO.User_DAO;
import com.bean.Entity.BookDetails;
import com.bean.Entity.NotificationClass;
import com.bean.Entity.UserDetails;

@Controller
@RequestMapping("/user")
public class LoginANDRegister_Controller {

	@Autowired
	private User_DAO userDao;

	@Autowired
	private Book_DAO bookDao;

	@Autowired
	private Notification_DAO notifyDao;

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
			UserDetails userResult = userDao.checkUser(user);

			if (userResult != null) {

				model.addAttribute("error", "The user already exists with current email.");
				return "/auth/register";

			} else {

				String result = userDao.registerUser(user);
				return "redirect:/user/login";
			}
		}
	}

	/* GET mapping for login page */
	@GetMapping("/login")
	public String showLogin(Model model) {

		model.addAttribute("user", new UserDetails());

		return "/auth/login";
	}

	/* POST mapping for login page */
	@PostMapping("/login")
	public String loginUser(@ModelAttribute("user") UserDetails user, Model model, HttpServletRequest req) {

		UserDetails userData = userDao.login(user);

		if (userData == null) {
			model.addAttribute("error", "Invalid credentials");
			return "/auth/login";
		} else {
			// model.addAttribute("user", userData);

			/*
			 * Setting the session
			 */
			HttpSession session = req.getSession();
			session.setAttribute("name", userData.getFirstName());
			session.setAttribute("id", userData.getId());
			session.setMaxInactiveInterval(3600);
			return "redirect:/home";
		}
	}

	/* GET mapping for login page */
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession();
		session.invalidate();

		return "redirect:/user/login";
	}

	/* Get mapping to get the pending requests */
	@GetMapping("/pendingRequests")
	public String getAllPendingRequests(HttpServletRequest req, Model model) {

		HttpSession session = req.getSession(false);

		if (session != null) {

			/* Getting logged in user's data */
			String userName = (String) session.getAttribute("name");
			int userId = (Integer) session.getAttribute("id");
			model.addAttribute("user", userName);

			/* Getting notifications for the current user */
			List<NotificationClass> resultNotifications = notifyDao.getNotificationForUser(userId);

			model.addAttribute("notifications", resultNotifications);

			return "/books/pendingReqPage";
		} else {
			model.addAttribute("reLogin", "Please log in again..");
			// return "/books/pendingReqPage";
			return "redirect:/user/login";
		}
	}

	@GetMapping("/userRequests")
	public String showUserRequestsStatus(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession(false);

		if (session != null) {

			/* Getting logged in user's data */
			String userName = (String) session.getAttribute("name");
			int userId = (Integer) session.getAttribute("id");
			model.addAttribute("user", userName);

			/* Getting all the notifications made by current user */
			List<NotificationClass> resultedNotifications = notifyDao.getNotificationMadeByTheUser(userId);

			model.addAttribute("notifications", resultedNotifications);

			return "/books/userRequestsStatusPage";

		} else {

			model.addAttribute("reLogin", "Please log in again..");
			return "redirect:/user/login";
		}
	}

	@GetMapping("/profile")
	public String userProfile(Model model, HttpServletRequest req) {

		HttpSession session = req.getSession(false);

		if (session != null) {

			/* Getting logged in user's data */
			String userName = (String) session.getAttribute("name");
			int userId = (Integer) session.getAttribute("id");
			model.addAttribute("user", userName);

			List<BookDetails> booksUploadedByUser = bookDao.getAllBooksUploadedByUser(userId);

			if (booksUploadedByUser.isEmpty()) {

				model.addAttribute("books", "");
				return "/auth/profilePage";
			}

			else {
				model.addAttribute("books", booksUploadedByUser);
				return "/auth/profilePage";
			}

		} else {

			model.addAttribute("reLogin", "Please log in again..");
			return "redirect:/user/login";
		}
	}

}
