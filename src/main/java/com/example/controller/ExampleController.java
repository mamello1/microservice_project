package com.example.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;
import com.example.repository.UserRepository;


@RestController
public class ExampleController {

	@Autowired
	UserRepository ur;
	
	private static final Log LOG = LogFactory.getLog(ExampleController.class);
	
	//Display all the users
	@GetMapping("/example/users")
	public List<User> displayAllUsers(){
		
		LOG.info("Inside Controller");
		User user = new User();
				
		user.setEmail("patience@gmail.com");
		user.setFName("Mamello");
		user.setJobTitle("Backend Developer");
		user.setLName("Mitane");
		user.setPassword("Mamello#1");
		
		ur.save(user);
		return ur.findAll();
		
	}
	
	// Creating a new user
	@RequestMapping(method = RequestMethod.POST, value = "/example/users")
	public User createUser(@RequestBody User u) {
		System.out.println("creating a user");
	    return ur.save(u);
	}
	
	
	// Retrieves a single user
	/*@GetMapping("/users/{userID}")
	public User getUserById(@PathVariable(value = "userID") Long id) {
		
	    return ur.findById(id).orElseThrow(() -> new Exception("User","userID",id));
	}*/

	
	// Update a users details
	/*@PutMapping("/users/{userID}")
	public User updateUser(@PathVariable(value = "userID") Long id,@RequestBody User userDetails) {

	    User e = ur.findById(id).orElseThrow(() -> new Exception("User","userID",id));

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
	public ResponseEntity<?> deleteNote(@PathVariable(value = "userID") Long id) {
		
	    User e = ur.findById(id).orElseThrow(() -> new Exception("User","userID",id));

	    ur.delete(e);

	    return ResponseEntity.ok().build();
	}*/
}




