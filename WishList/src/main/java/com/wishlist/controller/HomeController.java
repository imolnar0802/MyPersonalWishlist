package com.wishlist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wishlist.entity.User;
import com.wishlist.service.UserService;

@Controller
public class HomeController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("username", userService.getUsername());
		return "index";
	}
	
	@RequestMapping("/auth/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "auth/signup";
	}
	
	@RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String regnewuser(@ModelAttribute User user) {
		userService.regNewUser(user);
        return "auth/login";
    }
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest rA, Exception ex, Model model) {
		model.addAttribute("errMessage", ex.getMessage());
		return "exceptionHandler";
	}

}
