package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamehub.app.models.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

    // Show the login page (GET request)
    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("user", new LoginModel()); // Must match th:object="${user}"
        return "auth/login";
    }

    // Process the login form (POST request)
    @PostMapping
    public String processLogin(@ModelAttribute("user") LoginModel userModel, Model model) {
        // For now, simulate a successful login check
        if ("admin".equals(userModel.getUsername()) && "password".equals(userModel.getPassword())) {
            return "redirect:/home"; 
        }

        // If login fails
        model.addAttribute("errorMessage", "Invalid username or password.");
        return "auth/login";
    }
}