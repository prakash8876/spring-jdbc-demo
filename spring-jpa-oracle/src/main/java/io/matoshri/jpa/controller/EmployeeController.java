package io.matoshri.jpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.matoshri.jpa.model.Employee;
import io.matoshri.jpa.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
		return ResponseEntity.ok(service.fetchAll());
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> fetchEmployeeById(@RequestBody int empId) {
		return ResponseEntity.of(service.fetchByEmpId(empId));
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		return ResponseEntity.of(service.saveEmployee(emp));
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody int empId, @RequestBody Employee emp) {
		return ResponseEntity.of(service.updateEmployee(empId, emp));
	}
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@RequestBody int empId) {
		return ResponseEntity.ok(service.deleteEmployee(empId));
	}
}
