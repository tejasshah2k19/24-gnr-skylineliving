package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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

	@Autowired
	private JavaMailSender mailSender;

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

	@GetMapping(value = { "/", "login" })
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

	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";
	}

	@PostMapping("/sendotp")
	public String sendOtp(UserBean user) {
		// email read
		// db check
		UserBean userDB = userDao.findByEmail(user.getEmail());
		// otp generate
		if (userDB == null) {
			// email in invalid
			return "ForgotPassword";
		} else {
			// otp generate
			String data = "123456789";
			String otp = "";
			for (int i = 1; i <= 6; i++) {
				int x = (int) (Math.random() * 9);// 0
				otp = otp + data.charAt(x);// 31
			}
			
			//save into db 
			userDao.updateOtp(user.getEmail(),otp);
			// send ->mail -> otp
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmail());
			message.setSubject("OTP for Change Password");
			message.setText(otp);
			mailSender.send(message);
		}

		return "ChangePassword";
	}
}
