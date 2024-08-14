package com.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("users")
	public String getAllUsers(Model model) {

		// which?select
		// who? UserDao
		List<UserBean> users = userDao.getAllUsers();
		//send to ListUSers jsp ->
		model.addAttribute("users",users);
		
		return "ListUsers";
	}

}
