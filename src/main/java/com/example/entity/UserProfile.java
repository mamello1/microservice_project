package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//This annotation communicates with Hibernate to create a table from this class
@Table(name = "user_profile")
public class UserProfile {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_profile_id")
	int userProfileID;
	
	
	@Column(name = "user_type",nullable = false)
	String type = UserProfileType.USER.getUserProfileType();

	
	public void setProfileID(int i) {
		
		this.userProfileID = i;
	}
	
	public int getProfileID() {
		
		return userProfileID;
	}
	
	public void setProfileType(String t) {
		
		this.type = t;
	}
	
	
	public String getProfileType() {
		
		return type;
	}
	
}

