package com.app.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entities.User;
import com.app.service.IUserService;

@Controller
public class HomeController {
	@Autowired
	private IUserService userService;

	 public HomeController() {
		System.out.println("in ctor of "+getClass());
	}
	 @GetMapping("/")
	 public String showHomePage(Model map)
	 {
		 System.out.println("in home page");
		 map.addAttribute("ts", new Date());
		 return "/index";
	 }

		@GetMapping("/signup")
		public String signUpForm(User user) {
			
			return "/user/signup";
		}

		@PostMapping("/signup")
		public String processSignUpForm(@Valid User usr, Model map, HttpSession session, BindingResult result) {
			System.out.println("user details are "+usr);
			if(result.hasErrors()) {
				System.out.println("validation errors "+result);
				return "/user/signup";
			}
			System.out.println("new user added "+userService.addUser(usr));
			return "redirect:/user/login";
		}
		
}
