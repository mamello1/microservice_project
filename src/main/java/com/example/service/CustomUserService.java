package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.User;
import com.example.repository.UserRepository;

public class CustomUserService implements UserService{

	 @Autowired
	 private UserRepository ur;
	 
	 @Override	 
	 public User findByUsername(String userName) {
		 
	 return ur.findByUserName(userName);
	   
	    }
}
