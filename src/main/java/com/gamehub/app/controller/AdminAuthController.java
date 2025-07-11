package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.gamehub.app.models.AdminLoginModel;

@Controller
@RequestMapping("/admin")
public class AdminAuthController {

    @GetMapping("/login")
    public String showAdminLoginForm(Model model) {
        model.addAttribute("admin", new AdminLoginModel());
        return "auth/admin-login"; // Will create this view next
    }

    @PostMapping("/login")
    public String processAdminLogin(@ModelAttribute("admin") AdminLoginModel adminModel, Model model) {
        if ("Coque".equals(adminModel.getUsername()) && "test1234".equals(adminModel.getPassword())) {
            return "redirect:/admin/dashboard";
        }

        model.addAttribute("errorMessage", "Invalid admin credentials.");
        return "auth/admin-login";
    }
}