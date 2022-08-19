package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//custom query method : for replacing cross join by inner join
	@Query("select e from Employee e join e.dept d where d.id=:id")
	List<Employee> findByDepartment(@Param(value = "id") long deptId);
	
	@Query("select e from Employee e where e.id=:id")
	Employee findById(@Param(value="id")long empId);
}
