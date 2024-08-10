package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (firstName,email,password,role,contactNum) values (?,?,?,?,?) ",
				user.getFirstName(), user.getEmail(), user.getPassword(), user.getRole(), user.getContactNum());
	}

	public UserBean login(LoginBean loginBean) {
		UserBean user = null;
		try {
			user = stmt.queryForObject("select * from users where email  = ? and password = ?  ",
					new BeanPropertyRowMapper<>(UserBean.class),
					new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		} catch (Exception e) {

		}
		return user;
	}

}
