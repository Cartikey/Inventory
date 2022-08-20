package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entities.Country;

import com.app.service.ICountryService;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;
	@Autowired
	private ICountryService countryService;

	public UserController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");

		return "/user/login";// AVN : /WEB-INF/views/user/login.jsp
	}

	@PostMapping("/displayinfo")
	public String displayInfo(Model map, HttpSession session, String email, String pass) {
		System.out.println("in display info page");
		map.addAttribute("user_details", userService.authenticateUser(email, pass));
		return "/user/displayinfo";
	}

	@GetMapping("/showCountry/{userId}")
	public String showAllCountry(Model map, HttpSession session,@PathVariable long userId) {

		System.out.println("in show form of countries");
		System.out.println("user id" + userId);

		map.addAttribute("list_country", countryService.getAllCountries());
		session.setAttribute("user_id", userId);
		return "/user/showCountry";
	}

	// add a method to show the Model (Emp) --> form : Model --> View
	@GetMapping("/addCountries/{userId}")
	public String showNewCountryForm(Country cn, @PathVariable long userId, HttpSession session) // SC
																									// map.addAttribute("employee",new
																									// Employee());
	{
		System.out.println("in add new country form " + cn);
		System.out.println("user id  is " + userId);
		 session.setAttribute("userId", userId);
		return "/user/addCountry";
	}

//		//add a method to process the form date(view) ---> bound to the Model (Employee)
	@PostMapping("/addCountries/{userId}")
	public String processNewEmpForm(HttpSession session, Country c) {
		System.out.println("in process new emp form " + c);// all the fields set as per form data : except : emp id ,
															// dept id
		long user_id = (long) session.getAttribute("userId");
		System.out.println("user_id on process form " + user_id);
		System.out.println("Added new emp " + countryService.addCountryDetails(c, user_id));
		return "redirect:/user/showCountry/" + user_id;
	}

	// delete employee
	@GetMapping("/country/delete/{ctId}")
	public String delEmp(@PathVariable long ctId, HttpSession session) {
		long userId = (long) session.getAttribute("userId");
		System.out.println("in delete emp " + ctId);
		countryService.deleteCountry(ctId);
		return "redirect:/user/showCountry/" + userId;
	}

	// sort by population
//		@GetMapping("/sortCountries/{userId}")
//		public String sortCountries(@PathVariable long userId,Country country,Model map) {
//			map.addAttribute("sorted", countryService.sortByPopulation());
//			return "redirect:/user/showCountry?userId="+userId;
//		}

}
