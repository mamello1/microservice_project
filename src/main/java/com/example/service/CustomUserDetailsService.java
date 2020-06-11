package com.example.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {

	
	//static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
	//@Autowired
	//private UserRepository ur;
	
	/*@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName){
		
			User user = ur.findByUserName(userName);
		
		 if (user == null) throw new UsernameNotFoundException(userName);

	        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getFName()));
	        }

	        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
	    }
		
		
	}*/
	

   /*private List<GrantedAuthority> getGrantedAuthorities(User user){
		
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    
     
    for(UserProfile userProfile : user.getUserProfile()){
    	
        logger.info("UserProfile : {}", userProfile);
        
        authorities.add(new SimpleGrantedAuthority("role_"+userProfile.getProfileType()));
    }
    
    logger.info("Authorities : {}", authorities);
    
    return authorities;
	
	}
}*/
 
