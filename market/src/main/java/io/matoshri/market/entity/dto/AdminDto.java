package io.matoshri.market.entity.dto;

import java.util.List;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AdminDto {

	private final String adminName;
	private final List<Product> products;
	private final List<Employee> employees;
	
	public AdminDto(Admin admin) {
		this.adminName = admin.getAdminName();
		this.products = admin.getProducts();
		this.employees = admin.getEmployees();
	}
	
}
