package io.matoshri.market.service;

import java.util.List;

import io.matoshri.market.entity.dto.AdminDto;
import io.matoshri.market.entity.dto.EmployeeDto;
import io.matoshri.market.entity.dto.ProductDto;

public interface AdminService {
	
	void addAdmin(AdminDto admin);
	
	void addEmployeeList(List<EmployeeDto> employees);
	
	void addProductList(List<ProductDto> productList);
}
