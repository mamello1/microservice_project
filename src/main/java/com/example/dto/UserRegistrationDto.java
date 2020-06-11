package com.example.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.constraint.FieldMatch;

@FieldMatch.List({
    @FieldMatch(first = "userPassword", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "userEmail", second = "confirmEmail", message = "The email fields must match")
})

public class UserRegistrationDto {

    @NotEmpty
    private String userName;
    
    @NotEmpty
    private String userFName;
    
    @NotEmpty
    private String userLName;
    
    @NotEmpty
    private String userJobTitle;

    @NotEmpty
    private String userPassword;

    @NotEmpty
    private String confirmPassword;

    @Email
    @NotEmpty
    private String userEmail;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;
    
    
    public void setJobTitle(String userJobTitle) {
        this.userJobTitle = userJobTitle;
    }
    
    public String getJobTitle() {
        return userJobTitle;
    }
    
    public void setUsername(String userName) {
        this.userName = userName;
    }
    
    public String getUsername() {
        return userName;
    }

   
    public void setFName(String userFName) {
        this.userFName = userFName;
    }
    

   public String getFName() {
       return userFName;
    }
    

    public String getLName() {
        return userLName;
    }

    public void setLName(String userLName) {
        this.userLName = userLName;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return userEmail;
    }

    public void setEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

}
