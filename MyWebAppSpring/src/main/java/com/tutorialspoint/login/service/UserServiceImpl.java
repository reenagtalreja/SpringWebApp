package com.tutorialspoint.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.tutorialspoint.login.beans.Login;
import com.tutorialspoint.login.beans.User;
import com.tutorialspoint.login.dao.UserDao;
import com.tutorialspoint.login.dao.UserDaoImpl;
@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	  public UserDao userDao;
	@Override
	public void register(User user) {
		userDao.register(user);
		
	}

	@Override
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

}
