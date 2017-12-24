package com.tutorialspoint.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		//The username here is the property of bean class User and so on
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
				"name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"password.required");
		ValidationUtils.rejectIfEmpty(errors, "email", "email.required");
		ValidationUtils.rejectIfEmpty(errors, "phone", "phoneNumber.required");
		
	}

}
