package com.example.arkaFirmaApp.controllers;

import com.example.arkaFirmaApp.entities.Role;
import com.example.arkaFirmaApp.entities.User;
import com.example.arkaFirmaApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model){
        User user = adminService.getUserById(id);
        List<Role> roleList =adminService.getRoles();
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "update_user";
    }
    @PostMapping("/saveUser")
    public String saveEmployee(@ModelAttribute("employee") User user) {
        adminService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id){
        adminService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/user/{id}")
    public String getUserToUserPage(@PathVariable Long id, Model model){
        User user = adminService.getUserById(id);
        model.addAttribute("user", user);
        return "user_page";
    }

}
