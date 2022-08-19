package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.IDepartmentService;

@Controller
@RequestMapping("/")
public class DepartmentController {
	// dep : service layer i/f
	@Autowired
	private IDepartmentService deptService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping
	public String getAllDepts(Model map) {
		System.out.println("in get all depts ");
		map.addAttribute("depts", deptService.getAllDepartments());
		return "/department/dept";//AVN : /WEB-INF/views/department/dept.jsp
		
	}
}
