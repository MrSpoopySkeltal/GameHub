package com.gamehub.app.controller;
import com.gamehub.app.models.RegisterModel;
import com.gamehub.app.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new RegisterModel()); 
        return "auth/register";
    }

    @PostMapping
    public String processRegister(@Valid @ModelAttribute("user") RegisterModel userModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "auth/register"; // Show form again with errors
        }

        boolean success = authService.register(userModel.getUsername(), userModel.getPassword());

        if (success) {
            return "auth/register-success";
        }

        model.addAttribute("errorMessage", "Registration failed.");
        return "auth/register";
    }

}
