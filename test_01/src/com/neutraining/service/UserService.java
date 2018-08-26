package com.neutraining.service;

import java.sql.SQLException;

import com.neutraining.dao.UserDao;
import com.neutraining.model.User;

public class UserService {
	public boolean register(User user) throws SQLException {
		UserDao userDao = new UserDao();
		int count = userDao.getByUserName(user.getUsername());
		
		if(count != 0) {
			return false;
		}
		userDao.save(user);
		return true;
	}
}
