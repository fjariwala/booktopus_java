package com.bean.Hashing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionGetter {

	public String sessionGetter(HttpServletRequest req) {

		HttpSession session = req.getSession(false);

		if (session != null) {

			String userName = (String) session.getAttribute("name");
			return userName;
		} else {

			return null;
		}

	}

}
