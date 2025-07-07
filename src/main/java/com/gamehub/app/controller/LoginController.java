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
        // Check if username is "Coque" and password is "test1234"
        if ("Coque".equals(userModel.getUsername()) && "test1234".equals(userModel.getPassword())) {
            return "redirect:/admin/dashboard"; // Redirect to admin dashboard
        }

        // If login fails
        model.addAttribute("errorMessage", "Invalid username or password.");
        return "auth/login";
    }
}
