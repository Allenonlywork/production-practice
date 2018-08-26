package com.neutraining.service;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.neutraining.dao.UserDao;
import com.neutraining.model.User;

public class LoginService {
	public boolean login(String username, String password,HttpSession session) throws SQLException {
		//调用dao层，根据用户名和密码查询是否有该用户信息
		UserDao userDao = new UserDao();
		User user = userDao.getUserByUnAndPwd(username,password);
		if(user == null) { //数据库中查不到该用户名和密码，登录失败
			return false;
		}
		//数据库中可以查到该用户名和密码
		session.setAttribute("user",user);
		return true;
	}
}
