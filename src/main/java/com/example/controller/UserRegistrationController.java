package com.example.controller;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
    private UserService us;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Validated UserRegistrationDto userDto,BindingResult result){

        User existing = us.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("userEmail", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        us.save(userDto);
        return "redirect:/registration?success";
    }

}
