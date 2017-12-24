package com.tutorialspoint.login.service;

import org.springframework.stereotype.Service;

import com.tutorialspoint.login.beans.Login;
import com.tutorialspoint.login.beans.User;

public interface UserService {

  void register(User user);
  User validateUser(Login login);
}