package com.example.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//This annotation communicates with Hibernate to create a table from this class
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
		
	private String name;
	
	 public Role() {
	    }
	 
	 public Role(String name) {
	        this.setName(name);
	    }

	
	public void setID(long i) {//Set user ID
		
		this.id = i;
	}
	
	
	public long getID() {//Get user ID
		
		
		return id;
	}
		
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	 @Override
	    public String toString() {
	        return "Role{" +
	                "roleID=" + id +
	                ",name'" + name+ '\'' +
			        		  	               
	                '}';
	    }
}
