package com.gamehub.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.gamehub.app.models.LoginModel;
import com.gamehub.app.models.User;
import com.gamehub.app.repository.UserRepository;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showLoginForm(Model model) {
        model.addAttribute("user", new LoginModel());
        return "auth/login";
    }

    @PostMapping
    public String processLogin(@ModelAttribute("user") LoginModel loginModel, Model model) {
        User dbUser = userRepository.findByEmail(loginModel.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(loginModel.getPassword())) {
            if (dbUser.Admin()) {
                return "redirect:/admin/home";
            } else {
                return "redirect:/user/dashboard";
            }
        }

        model.addAttribute("errorMessage", "Invalid username or password.");
        return "auth/login";
    }

}
