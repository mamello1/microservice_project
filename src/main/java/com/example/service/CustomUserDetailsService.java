package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.service.UserService;
import com.example.entity.User;
import com.example.entity.UserProfile;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	UserService us;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = us.findByUsername(userName);
		
		logger.info("User : {}" ,user);
		
		if(user == null) {
			
			logger.info("User Is Not Found");
			
			throw new UsernameNotFoundException("User Not Found");
		}
		
		 return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),  true, true, true, true, getGrantedAuthorities(user));
	}
	

	private List<GrantedAuthority> getGrantedAuthorities(User user){
		
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    
     
    for(UserProfile userProfile : user.getUserProfile()){
    	
        logger.info("UserProfile : {}", userProfile);
        
        authorities.add(new SimpleGrantedAuthority("role_"+userProfile.getProfileType()));
    }
    
    logger.info("Authorities : {}", authorities);
    
    return authorities;
}
	
	}
 
