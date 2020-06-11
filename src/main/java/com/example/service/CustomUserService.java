package com.example.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.repository.UserRepository;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.dto.UserRegistrationDto;

@Service
public class CustomUserService implements UserService{

	 @Autowired
	 private UserRepository ur;
	 	 
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	  
	  
	 public User findByEmail(String userEmail) {
		 
	 return ur.findByEmail(userEmail);
	   
	  }
	 
	 
	public User save(UserRegistrationDto registration){
		
	  User user = new User();
	  user.setFName(registration.getFName());
	  user.setLName(registration.getLName());
	  user.setEmail(registration.getEmail());
	  user.setJobTitle(registration.getJobTitle());
	  user.setPassword(bCryptPasswordEncoder.encode(registration.getPassword()));
	  user.setRoles(Arrays.asList(new Role("ROLE_USER")));
	  
	  return ur.save(user);
	    }
	
	 @Override
	 public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		 
	  User user = ur.findByEmail(userEmail);
	  
	  if (user == null){
		  
	            throw new UsernameNotFoundException("Invalid username or password.");
	            
	   }
	  
	    return new org.springframework.security.core.userdetails.User(user.getEmail(),
	        		
	       user.getPassword(),
	       mapRolesToAuthorities(user.getRoles()));
	    }
	 

	  private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
	        return roles.stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName()))
	                .collect(Collectors.toList());
	    }
}
