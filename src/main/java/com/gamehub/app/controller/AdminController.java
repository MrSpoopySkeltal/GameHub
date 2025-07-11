package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "admin/admin-dashboard";
    }

    @GetMapping("/products")
    public String manageProducts() {
        return "admin/products"; 
    }

    @GetMapping("/orders")
    public String manageOrders() {
        return "admin/orders"; 
    }

    @GetMapping("/users")
    public String manageUsers() {
        return "admin/users";
    }

    @GetMapping("/home")
    public String showHome() {
        return "admin/home"; // fix for login redirect!
    }
}

