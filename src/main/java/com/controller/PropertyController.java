package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;

import jakarta.servlet.http.HttpSession;

@Controller
public class PropertyController {

	@GetMapping("/newproperty")
	public String newProperty() {
		return "NewProperty";
	}

	@GetMapping("/markfav")
	public String markAsFav(@RequestParam("propertyId") Integer propertyId, HttpSession session) {
		// pid
		// uid
		UserBean user = (UserBean) session.getAttribute("user");
		Integer userId = user.getUserId();

		// insert -> fav -> insert into fav (userId,propertyId) values (?,?);

		return "";
	}
}
