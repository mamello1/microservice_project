package com.example.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

	@Entity//This annotation communicates with Hibernate to create a table from this class
	@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "user_email") )
	public class User {
		
				@Id
				@GeneratedValue(strategy=GenerationType.AUTO)
				@Column(name = "user_id")
				long userID;
								
				@Column(name = "user_job_title",nullable = false)
				String userJobTitle;			

				@Column(name = "user_first_name",nullable = false)
				String userFName;

				@Column(name = "user_last_name",nullable = false)
				String userLName;

				@Column(name = "user_email",nullable = false)
				String userEmail;
								
				@Column(name = "user_password",nullable = false)
				String userPassword;	
			
				@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			    @JoinTable(name = "users_roles",
			    joinColumns = @JoinColumn( name = "user_id", referencedColumnName = "user_id"),
			    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
			    private Collection <Role>  roles;
				
				public User() {
			    }

				public User(String userFName, String userLName,String userEmail,String userJobTitle, String userPassword) {
					
		
					 this.userFName = userFName;
				     this.userEmail = userEmail;
				     this.userJobTitle = userJobTitle;
				     this.userPassword = userPassword;
				       
				    }
				
				public User(String userFName, String userLName,String userEmail,String userJobTitle, String userPassword, Collection<Role> roles) {
				       this.userFName = userFName;
				       this.userLName = userLName;
				       this.userEmail = userEmail;
				       this.userJobTitle = userJobTitle;
				       this.userPassword = userPassword;
				       this.roles = roles;
				    }

			   				
				public void setID(long i) {//Set user ID
					
					this.userID = i;
				}
				
				
				public long getID() {//Get user ID
					
					
					return userID;
				}
							
				
				public void setPassword(String ps) {//Set user password
					
					this.userPassword = ps;
				}
				
				
				public String getPassword() {//Get user password
					
					
					return userPassword;
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
				

			    public Collection <Role> getRoles() {
			        return roles;
			    }

			    public void setRoles(Collection < Role > roles) {
			        this.roles = roles;
			    }
			    
			    @Override
			    public String toString() {
			        return "User{" +
			                "id=" + userID +			         
			                ", userFName='" + userFName + '\'' +
			                ", userLName='" + userLName + '\'' +			                
			                ", userEmail='" + userEmail + '\'' +
			                ", userJobTitle='" + userJobTitle + '\'' +
			                ", userPassword='" + "*********" + '\'' +
			                ", roles=" + roles +
			                '}';
			    }

}
