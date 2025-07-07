package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamehub.app.models.LoginModel;
import com.gamehub.app.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("user", new LoginModel());
        return "auth/login";
    }

    @PostMapping
    public String processLogin(@ModelAttribute("user") LoginModel userModel, Model model) {
        if (authService.authenticate(userModel.getUsername(), userModel.getPassword())) {
            return "redirect:/home";
        }
        model.addAttribute("errorMessage", "Invalid username or password.");
        return "auth/login";
    }
}
