package com.example.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.entity.User;
import com.example.service.UserService;

	public class UserValidator implements Validator {

	@Autowired
	UserService us;
	
	@Override
    public boolean supports(Class<?> aClass) {
		
        return User.class.equals(aClass);
        
    }
	
	
	@Override
	public void validate(Object o, Errors e) {
		
		User u = (User) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "userName", "NotEmpty", "This is not supposed to be empty");;
		 
		if(u.getUserName().length() < 5|| u.getUserName().length() > 32) {
			
			e.rejectValue("userName","Size.userForm.userName");
		}
			
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"userFName", "NotEmpty","This is not supposed to be empty");
		
		if(u.getFName().length() < 5|| u.getFName().length() > 32) {
			
			e.rejectValue("userFName","Size.userForm.userFName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"userLName", "NotEmpty","This is not supposed to be empty");
		
		if(u.getLName().length() < 5|| u.getLName().length() > 32) {
			
			e.rejectValue("userLName","Size.userForm.userLName");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"userJobTitle", "NotEmpty","This is not supposed to be empty");
		
		if(u.getJobTitle().length() < 5|| u.getJobTitle().length() > 32) {
			
			e.rejectValue("userJobTitle","Size.userForm.userJobTitle");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(e,"userPassword", "NotEmpty","This is not supposed to be empty");
		
		if(u.getPassword().length() < 5|| u.getPassword().length() > 20) {
			
			e.rejectValue("userPassword","Size.userForm.userPassword");
		}
		
		 if (!u.getConfirmPassword().equals(u.getPassword())) {
			 
	        e.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
	            
	    }
		
	}
	
}
