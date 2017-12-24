package com.tutorialspoint.login.dao;

import org.springframework.stereotype.Service;

import com.tutorialspoint.login.beans.Login;
import com.tutorialspoint.login.beans.User;

public interface UserDao {
	void register(User user);
	User validateUser(Login login);
}
