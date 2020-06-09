package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private UserDetailsService usd;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		 .antMatchers("/example/**")
		 .access("hasRole('USER') or hasRole('ADMIN') or hasRole('DBA')")
		 .antMatchers("/createUser").access("hasRole('USER')")
		 .antMatchers("/createUser","/updateUser","deleteUser").access("hasRole('ADMIN')")
		 .antMatchers("/updateUser","deleteUser").access("hasRole('DBA')")	
		 .antMatchers("/resources/**", "/register").permitAll()
	     .anyRequest()
	     .authenticated()
	     .and()
	     .formLogin()
	     .loginPage("/login")
	     .permitAll();
		 	 
		 http.csrf().disable();
	
	}
	
	public AuthenticationManager customAuthenticationManager() throws Exception {
		
        return authenticationManager();
        
    }
	
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	
        return new BCryptPasswordEncoder();
    }
	

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder a) throws Exception {
    	    	
        a.userDetailsService(usd).passwordEncoder(bCryptPasswordEncoder());
        
    }
    
    
   


	}

