package io.matoshri.market.utils;

import org.modelmapper.ModelMapper;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.entity.Invoice;
import io.matoshri.market.entity.Product;
import io.matoshri.market.entity.dto.AdminDto;
import io.matoshri.market.entity.dto.CustomerDto;
import io.matoshri.market.entity.dto.EmployeeDto;
import io.matoshri.market.entity.dto.InvoiceDto;
import io.matoshri.market.entity.dto.ProductDto;

public class ConvertTo {
	
	private static final ModelMapper mapper = new ModelMapper();

	private ConvertTo() {
	}

	public static Admin adminEntity(AdminDto dto) {
		return mapper.map(dto, Admin.class);
	}

	public static Customer customerEntity(CustomerDto dto) {
		return mapper.map(dto, Customer.class);
	}

	public static Employee employeeEntity(EmployeeDto dto) {
		return mapper.map(dto, Employee.class);
	}

	public static Invoice invoiceEntity(InvoiceDto dto) {
		return mapper.map(dto, Invoice.class);
	}

	public static Product productEntity(ProductDto dto) {
		return mapper.map(dto, Product.class);
	}
}
