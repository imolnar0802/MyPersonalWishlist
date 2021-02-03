package com.wishlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wishlist.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("username",userService.getUsername());
		return "index";
	}

}
