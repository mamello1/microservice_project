package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.entity.User;

import com.example.dto.UserRegistrationDto ;

public interface UserService extends UserDetailsService{
	
    User findByEmail(String userEmail);
    
    User save(UserRegistrationDto registration);
       
}
