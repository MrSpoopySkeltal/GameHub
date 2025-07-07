package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "admin/admin-dashboard"; // points to templates/admin/admin-dashboard.html
    }
}
