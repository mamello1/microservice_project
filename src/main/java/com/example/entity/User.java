package com.example.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


	@Entity//This annotation communicates with Hibernate to create a table from this class
	@Table(name = "users")
	public class User {
		
				@Id
				@GeneratedValue(strategy=GenerationType.AUTO)
				@Column(name = "user_id")
				long userID;
								
				@Column(name = "user_job_title",nullable = false)
				String userJobTitle;
				
				@Column(name = "user_name",nullable = false)
				String userName;

				@Column(name = "user_first_name",nullable = false)
				String userFName;

				@Column(name = "user_last_name",nullable = false)
				String userLName;

				@Column(name = "user_email",nullable = false)
				String userEmail;
								
				@Column(name = "user_password",nullable = false)
				String userPassword;
				
				@Column(name = "user_confirm_password",nullable = false)
				String confirmPassword;
					
				@OneToMany(fetch = FetchType.LAZY)
				@JoinTable(name = "user_user_profile")
				@JoinColumn(name = "user_id")
				private Set<UserProfile> userProfile= new HashSet<UserProfile>();
				
				
				public void setID(long i) {//Set user ID
					
					this.userID = i;
				}
				
				
				public long getID() {//Get user ID
					
					
					return userID;
				}
				
				
				public void setUsername(String un) {//Set user password
					
					this.userName = un;
				}
				
				
				public String getUserName() {//Get user password
					
					
					return userName;
				}
				
				
				
				public void setPassword(String ps) {//Set user password
					
					this.userPassword = ps;
				}
				
				
				public String getPassword() {//Get user password
					
					
					return userPassword;
				}
				
				
				public void setConfirmPassword(String cps) {//Set user password
					
					this.confirmPassword = cps;
				}
				
				
				public String getConfirmPassword() {//Get user password
					
					
					return confirmPassword;
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
				
				
				public void setEmail(String e) {//Set user email
					
					this.userEmail = e;
				}
				
				public String getEmail() {//Get user email
					
					
					return userEmail;
				}
				
				
				public void setUserProfile(Set<UserProfile> ups) {
					
				      this.userProfile = ups;
				    }
				  
				public Set<UserProfile> getUserProfile() {
			        
					return userProfile;
			    
			    }


			  

}
