package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "user/user-dashboard";
    }

    @GetMapping("/edit-profile")
    public String showEditProfile() {
        return "user/edit-profile";
    }

    @PostMapping("/edit-profile")
    public String saveProfile(/* You can handle data here */) {
        // Simulate saving
        return "redirect:/user/dashboard";
    }
}