package com.example.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.entity.UserProfile;
import com.example.service.CustomUserDetailsService;
import com.example.service.UserProfileService;

	@Component
	public class RoleToUserProfile implements Converter<Object,UserProfile>{
	
	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfile.class);

	@Autowired
	UserProfileService ups;
	
	
	//Gets the UserProfile by userID
	public UserProfile convert(Object element) {
		
		Integer id = Integer.parseInt((String)element);
		
		UserProfile p = ups.findById(id);
		
		logger.info("Profile : {} ",p);
		
		return p;
	}
	
	
}
