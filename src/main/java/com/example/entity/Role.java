package com.example.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity//This annotation communicates with Hibernate to create a table from this class
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	long userID;
	
	@Column(name = "user_name",nullable = false)
	String userName;
					
	@Column(name = "user_first_name",nullable = false)
	String userFName;
	
	@Column(name = "user_last_name",nullable = false)
	String userLName;
	
	@Column(name = "user_job_title",nullable = false)
	String userJobTitle;
		
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;
	
	
	public void setID(long i) {//Set user ID
		
		this.userID = i;
	}
	
	
	public long getID() {//Get user ID
		
		
		return userID;
	}
	
	
	public void setUsername(String un) {//Set user name
		
		this.userName = un;
	}
	
	
	public String getUserName() {//Get user name
		
		
		return userName;
	}
	
						
	public void setJobTitle(String j) {//Set user job title
		
		this.userJobTitle = j;
	}
	
	
	public String getJobTitle() {//Get user job title
		
		return userJobTitle;
	}
	
	public void setFName(String fn) {//Set user first name
		
		this.userFName = fn;
	}
	
	public String getFName() {//Get user first name
		
		
		return userFName;
	}
	
	
	public void setLName(String ln) {//Set last name
		
		this.userLName = ln;
	}
	
	public String getLName() {//Get last name
		
		
		return userLName;
	}

	public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
