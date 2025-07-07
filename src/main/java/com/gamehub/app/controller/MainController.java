package com.gamehub.app.controller;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.gamehub.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class MainController {
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "GameHub - Your Ultimate Gaming Destination");
        return "index";
    }
    
    
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO()); 
        model.addAttribute("pageTitle", "Register - GameHub");
        return "auth/register";
    }

    
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("pageTitle", "Products - GameHub");
        return "products/index";
    }
    
    @GetMapping("/user-management")
    public String userManagement(Model model,
                               @RequestParam(required = false) String username) {
        model.addAttribute("pageTitle", "User Management - GameHub");
        model.addAttribute("searchUsername", username != null ? username : "");
        return "admin/user-management";
    }
    
    @PostMapping("/register")
    public String processRegistration(
            @Valid @ModelAttribute("user") UserDTO userDTO,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Register - GameHub");
            return "auth/register";
        }

        // Simulate a successful registration (DB part comes later)
        return "auth/thankyou";

    }

}
