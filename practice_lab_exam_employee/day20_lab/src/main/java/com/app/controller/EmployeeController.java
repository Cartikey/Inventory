package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.entities.Employee;
import com.app.service.IEmployeeService;

@Controller
@RequestMapping("/dept/emp")
public class EmployeeController {
	//dep : emp service
	@Autowired
	private IEmployeeService empService;
	private Employee empDetails;
	
	public EmployeeController() {
		System.out.println("in ctor of "+getClass());
		
	}
	//add a method to display list of emsp for particular dept
	@GetMapping("/list")
	//@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public String listEmps(Model map,@RequestParam long deptId,HttpSession session)
	{
		System.out.println("in list emps "+deptId);
		map.addAttribute("emp_list",empService.findByDepartment(deptId));
		session.setAttribute("dept_id", deptId);
	
		return "/emp/list";//AVN : WEB-INF/views/emp/list.jsp		
	}
	//add a method to show the Model (Emp) --> form : Model --> View 
	@GetMapping("/add")
	public String showNewEmpForm(Employee emp) //SC map.addAttribute("employee",new Employee());
	{
		System.out.println("in show new emp form "+emp);
		return "/emp/show_form";
	}
	//add a method to process the form date(view) ---> bound to the Model (Employee)
	@PostMapping("/add")
	public String processNewEmpForm(HttpSession session,Employee e)
	{
		System.out.println("in process new emp form "+e);//all the fields set as per form data : except : emp id , dept id
		long deptId= (long)session.getAttribute("dept_id");
		System.out.println("Added new emp "+empService.addEmpDetails(e,deptId));
		return "redirect:/dept/emp/list?deptId="+deptId;
	}
	
	@GetMapping("/del/{empId}")
	public String delEmp(@PathVariable long empId,HttpSession session) {
		long deptId= (long)session.getAttribute("dept_id");
		System.out.println("in delete emp "+empId);
		empService.deleteEmp(empId);
		return "redirect:/dept/emp/list?deptId="+deptId;
	}
	
	//to update employee details
	@GetMapping("/edit/{empId}")
	public String getEmpDetails(@PathVariable long empId,Model map,HttpSession session,Employee emp)
	{  map.addAttribute("emp_details", empService.getEmpDetails(empId));
	//System.out.println("model attri"+addAttribute);	
	//System.out.println("in get emp details update"+emp);
		System.out.println("in get emp dtls map"+map);
		//map.addAttribute("emp_details", empService.getEmpDetails(empId));
	    session.setAttribute("emp_id", empId);
		 return "/emp/edit";
	}
	
		@PostMapping("/edit/{empId}")
		public String updateEmpDetails( Employee emp,HttpSession session,@PathVariable long empId)
		{  System.out.println("in update  emp dtls"+emp);
		
		System.out.println("employee id "+empId);
		long deptId= (long)session.getAttribute("dept_id");
	     System.out.println("department id "+deptId);
		 System.out.println("Update employee"+empService.updateEmpDetails(emp,empId,deptId));
		
			return "redirect:/dept/emp/list?deptId="+deptId;
		}
	

}
