package com.sample.service;

import com.sample.dao.UserDao;
import com.sample.domain.User;

//用户业务类
public class UserService {

	public User login(User user) {
		UserDao userDao = new UserDao();
		return userDao.queryUser(user);
	}

}
