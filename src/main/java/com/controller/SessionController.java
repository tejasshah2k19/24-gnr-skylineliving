package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {

	@Autowired
	UserDao userDao;

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		// db insert
		user.setRole("USER");

		userDao.addUser(user);
		return "Login";
	}

	@GetMapping(value = {"/","login"})
	public String login() {
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(LoginBean loginBean) {
		// db
		// Home
		// Login
		UserBean user = userDao.login(loginBean);
		if (user == null) {
			// invalid credentials
			return "Login";
		} else {
			if (user.getRole().equals("USER")) {
				return "Home";
			} else if (user.getRole().equals("ADMIN")) {
				return "AdminHome";
			} else {
				return "Login";
			}
		}
	}
}
