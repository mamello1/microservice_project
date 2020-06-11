package com.example.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;



@RestController
public class ExampleController {

	//@Autowired
	//UserRepository ur;
		
	//@Autowired
	//private BCryptPasswordEncoder passwordencoder;
	
	 //@Autowired
	 //private UserService us;
	 
	
	 @GetMapping("/")
	    public String root() {
	        return "index";
	    }

	    @GetMapping("/login")
	    public String login(Model model) {
	        return "login";
	    }

	    @GetMapping("/user")
	    public String userIndex() {
	        return "user/index";
	    }
	
	//private static final Log LOG = LogFactory.getLog(ExampleController.class);
	
	//Display all the users
	/*@GetMapping("/example/users")
	public List<User> displayAllUsers(){
		
		LOG.info("Inside Controller");
		
		User user = new User();
		
		user.setEmail("patience@gmail.com");
		user.setFName("Mamello");
		user.setJobTitle("Backend Developer");
		user.setLName("Mitane");
		user.setPassword("Mamello#1");
		user.setConfirmPassword("Mamello#1");
		user.setUsername("Mamello_1");
	
		ur.save(user);
		
		return ur.findAll();
		
	}*/
	
	//Creates a new user	
	/*@PostMapping("/example/users")
	public User createUser(@RequestBody User u) {
		
		LOG.info("User Password" + u.getPassword());
			
		String encoderPassword = passwordencoder.encode(u.getPassword());	
		u.setPassword(encoderPassword);
	    return ur.save(u);
	    
	}*/
	
	/* @GetMapping({"resources/welcome"})
	    public String welcome(Model model) {
		 
	        return "welcome";
	        
	    }*/
	
	 /*@GetMapping("resources/login")
	    public String login(Model model, String error, String logout) {
	        if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");

	        if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");

	        return "login";
	    }*/
	
	 /*@GetMapping("/resources/registration")
	 public String registration(Model model) {
		 
	 model.addAttribute("userForm", new User());

	 return "registration";
	        
	 }*/
	
	 /*@PostMapping("/registration")
	 public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		 
	   uv.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	        	
	            return "registration";
	        }

	        us.save(userForm);

	       //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "redirect:/welcome";
	    }*/
	
	//Shows the login form
	/*@GetMapping("/resources/login")
	public String showLoginForm(WebRequest request, Model model) {
		
		LOG.info("Show Login Form");
		
	    User u = new User();
	    model.addAttribute("user", u);
	    return "login";
	}*/
	
	//Shows the registration form
	/*@GetMapping("/resources/register")
	public String showRegistrationForm(WebRequest request, Model model) {
		
		LOG.info("Show Registration Form");
		
	    User u = new User();
	    model.addAttribute("user", u);
	    return "registration";
	}*/
	
	
	// Retrieves a single user
	/*@GetMapping("/users/{userID}")
	public User getUserById(@PathVariable(value = "userID") Long id) {
		
	    return ur.findById(id).orElseThrow(() -> new Exception("User","userID",id));
	}*/

	
	// Update a users details
	/*@PutMapping("/users/{userID}")
	public User updateUser(@PathVariable(value = "userID") Long id,@RequestBody User userDetails) {

	    User e = ur.findById(id).orElseThrow(() -> new IException("User",id));

	    e.setPassword(userDetails.getPassword());
	    e.setFName(userDetails.getFName());
	    e.setLName(userDetails.getLName());
	    e.setJobTitle(userDetails.getJobTitle());
	    e.setEmail(userDetails.getEmail());
	  
	    User updatedUser = ur.save(e);
	    return updatedUser;
	}*/
	
	//Deleting a user
	/*@DeleteMapping("/users/{userID}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "userID") Long id) {
		
	    User e = ur.findById(id).orElseThrow(() -> new Exception("User","userID",id));

	    ur.delete(e);

	    return ResponseEntity.ok().build();
	}*/
}




