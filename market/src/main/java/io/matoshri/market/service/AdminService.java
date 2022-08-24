package io.matoshri.market.service;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.exception.ResourceNotFoundException;

public interface AdminService {
	
	void newAdmin(Admin admin);
	
	void newEmployee(Employee employee);
	
	void updateEmployee(int employeeId, Employee employee) throws ResourceNotFoundException;
	
	void deleteEmployee(int employeeId) throws ResourceNotFoundException;

}
