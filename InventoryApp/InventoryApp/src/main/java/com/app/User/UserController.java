package com.app.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	public UserController(UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	@GetMapping("/")
	public String login() {
		System.out.println("inside get login ");
		return "login";
	}

	@PostMapping("/")
	public String loginProcess(@RequestBody String body) {

		
		  System.out.println("inside post login");
		  System.out.println("User:  "+body+" "); String[] str = body.split("&");
		  String email = str[0].split("=")[1]; String password = str[1].split("=")[1];
		  System.out.println("-------------------------------------");
		  System.out.println("email: "+email);
		  System.out.println("password: "+password);
		  System.out.println("-------------------------------------");
		 
		

		System.out.println(email + " --- " + password);
		User user = userRepository.findByNameAndPassword(email, password);
		
		System.out.println("-------------------------------------");
		System.out.println(user);
		System.out.println("-------------------------------------");

		if (user == null)
			return "login";
		else if (user.getRole().name().equals("ADMIN")){
			return "index";
		}
		return "indexCustomer";
	}

}
