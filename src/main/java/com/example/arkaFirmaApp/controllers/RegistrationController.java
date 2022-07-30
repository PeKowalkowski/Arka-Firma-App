package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Registration;
import com.example.arkaFirmaApp.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showFormForRegistration(Model model){
        model.addAttribute("user", new Registration());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("user") Registration registration){
        userService.save(registration);
        return "login";
    }

}
