package io.matoshri.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	private AdminService service;

	@Autowired
	public AdminController(AdminService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/new/admin")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAdmin(@RequestBody Admin admin) {
		this.service.newAdmin(admin);
	}

	@PostMapping("/new/admin")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody Employee employee) {
		this.service.newEmployee(employee);
	}
	
	@PutMapping("{employeeId}")
	public void updateEmployee(@PathVariable int employeeId,@RequestBody Employee employee) {
		this.service.updateEmployee(employeeId, employee);
	}
	
	@DeleteMapping("{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		this.service.deleteEmployee(employeeId);
	}
	
	
	
}
