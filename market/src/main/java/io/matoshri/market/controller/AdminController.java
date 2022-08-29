package io.matoshri.market.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.matoshri.market.entity.dto.AdminDto;
import io.matoshri.market.entity.dto.EmployeeDto;
import io.matoshri.market.service.AdminService;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

	private final AdminService service;

	public AdminController(AdminService service) {
		this.service = service;
	}

	@PostMapping("/new/admin")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAdmin(@RequestBody AdminDto admin) {
		this.service.addAdmin(admin);
	}

	@PostMapping("/new/admin/employee")
	@ResponseStatus(HttpStatus.CREATED)
	public void createEmployee(@RequestBody EmployeeDto employee) {
		this.service.addEmployeeList(Arrays.asList(employee));
	}

}
