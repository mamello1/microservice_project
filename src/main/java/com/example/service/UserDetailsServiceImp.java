package com.example.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository ur;
	
	public UserDetails loadUserByUsername(String userName) {
		
        User user =  ur.findByUserName(userName);
        
        if (user == null) throw new UsernameNotFoundException(userName);

        Set<GrantedAuthority> ga = new HashSet<>();
        
        for (Role role : user.getRoles()){
        	
            ga.add(new SimpleGrantedAuthority(role.getUserName()));
            
        }

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), ga);
       
    }
}
