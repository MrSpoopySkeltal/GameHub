package com.gamehub.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gamehub.app.models.ProductModel;

@Controller
@RequestMapping("/product")
public class ProductController {

    /// GET: Show the form
	@GetMapping("/create")
	public String showCreateForm(Model model) {
	    model.addAttribute("product", new ProductModel());
	    return "products/create"; 
	}

	// POST: Handle form submission
	@PostMapping("/create")
	public String processCreateForm(@ModelAttribute("product") ProductModel product, Model model) {
	    
	    return "redirect:/product/thankyou"; // Redirect to thank-you page
	}

	// GET: Thank You Page
	@GetMapping("/thankyou")
	public String showThankYouPage() {
	    return "products/thankyou"; 
	}
}