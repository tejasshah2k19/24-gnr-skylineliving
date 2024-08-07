package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;

@Controller
public class SessionController {

	@Autowired
	JdbcTemplate stmt;

	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		// db insert
		user.setRole("USER");
		stmt.update("insert into users (firstName,email,password,role,contactNum) values (?,?,?,?,?) ",
				user.getFirstName(), user.getEmail(), user.getPassword(), user.getRole(), user.getContactNum());
		return "Login";
	}
}
