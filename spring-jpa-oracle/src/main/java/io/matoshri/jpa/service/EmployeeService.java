package io.matoshri.jpa.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.matoshri.jpa.exception.EmployeeNotFoundException;
import io.matoshri.jpa.model.Employee;

public interface EmployeeService {
	
	List<Employee> fetchAll();
	
	Optional<Employee> fetchByEmpId(Integer id) throws EmployeeNotFoundException;
	
	Optional<Employee> saveEmployee(Employee emp);
	
	Optional<Employee> updateEmployee(Integer empId, Employee emp) throws EmployeeNotFoundException;
	
	Map<String, Boolean> deleteEmployee(Integer empId) throws EmployeeNotFoundException; 
}
