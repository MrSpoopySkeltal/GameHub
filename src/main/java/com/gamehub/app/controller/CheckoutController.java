package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckoutController {
    @GetMapping("/checkout")
    public String showCheckout() {
        return "user/checkout"; // place this file under templates/user/checkout.html
    }
}