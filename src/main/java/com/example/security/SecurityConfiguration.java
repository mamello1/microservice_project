package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	/*@Autowired
    private UserDetailsService usd;*/
	
	@Autowired
	UserService us;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* http.authorizeRequests()
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
	     .permitAll();*/
		
		 http
         .authorizeRequests()
         .antMatchers(
          "/registration**",
          "/js/**",
          "/css/**",
          "/img/**")
         .permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login")
         .permitAll()
         .and()
         .logout()
         .invalidateHttpSession(true)
         .clearAuthentication(true)
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/login?logout")
         .permitAll();
		 	 
		 http.csrf().disable();
	
	}
	
	/*public AuthenticationManager customAuthenticationManager() throws Exception {
		
        return authenticationManager();
        
    }*/
	
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
    	
        return new BCryptPasswordEncoder();
    }
	
	 @Bean
	    public DaoAuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider a = new DaoAuthenticationProvider();
	        a.setUserDetailsService(us);
	        a.setPasswordEncoder(bCryptPasswordEncoder());
	        return a;
	    }

	

    @Autowired
    public void configure(AuthenticationManagerBuilder a) throws Exception {
    	    	
        a.authenticationProvider(authenticationProvider());
        
    }
    
    
   


	}

