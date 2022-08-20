package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired //inject emprepo using autowired annotn
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(); //find all returns Lis<Emp>
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> optional= employeeRepository.findById(id);
		 Employee employee = null;
	        if (optional.isPresent()) {
	            employee = optional.get();
	        } else {
	            throw new RuntimeException(" Employee not found for id :: " + id);
	        }
	        return employee;
	}

	@Override
	public void deleteEmployeeById(long id) {
		 this.employeeRepository.deleteById(id);
	}
	
	

}
