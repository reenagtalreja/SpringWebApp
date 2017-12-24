package com.tutorialspoint.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tutorialspoint.login.beans.User;
import com.tutorialspoint.login.service.UserService;
import com.tutorialspoint.login.service.UserServiceImpl;
import com.tutorialspoint.validator.UserValidator;
@Controller
public class RegistrationController {
	@Autowired
	  private UserService userService;
	@Autowired
	  private UserValidator userValidator;
	//The actual code has HttpServletRequest and HttpServletResponse which is not required in the paramter list
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister() {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new User());
	    return mav;
	  }
	  //The actual code has HttpServletRequest and HttpServletResponse which is not required in the paramter list
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(@ModelAttribute("user") User user,BindingResult result) {
			userValidator.validate(user, result);
			if (result.hasErrors()) {
				// return new ModelAndView("errorMessage");
				 return new ModelAndView("register");
			} else {
				  userService.register(user);
				  return new ModelAndView("welcome", "firstname", user.getFirstname());
			}
	  }
}
