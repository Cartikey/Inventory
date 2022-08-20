package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {//Backend part
	//method handlers mentioned in view/html pages are declared here, 
	//defination for these crud operation given in serviceImpl class, controller will handle these methods 

	List<Employee> getAllEmployees();
	
	void saveEmployee(Employee employee);
	
    Employee getEmployeeById(long id);
    
    void deleteEmployeeById(long id);
}
