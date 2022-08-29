package io.matoshri.market.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.matoshri.market.entity.dto.AdminDto;
import io.matoshri.market.entity.dto.EmployeeDto;
import io.matoshri.market.entity.dto.ProductDto;
import io.matoshri.market.repository.AdminRepository;
import io.matoshri.market.repository.EmployeeRepository;
import io.matoshri.market.repository.ProductRepository;
import io.matoshri.market.service.AdminService;
import io.matoshri.market.utils.ConvertTo;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepo;
	private final EmployeeRepository employeeRepo;
	private final ProductRepository productRepo;

	public AdminServiceImpl(AdminRepository adminRepo, EmployeeRepository employeeRepo, ProductRepository productRepo) {
		this.adminRepo = adminRepo;
		this.employeeRepo = employeeRepo;
		this.productRepo = productRepo;
	}

	@Override
	public void addAdmin(AdminDto admin) {
		adminRepo.save(ConvertTo.adminEntity(admin));
		log.info("New Admin Created : {}", admin);
	}

	@Override
	public void addProductList(List<ProductDto> productList) {
		productRepo.saveAll(productList.stream().map(ConvertTo::productEntity).toList());
		log.info("Product List added" + productList);
	}

	@Override
	public void addEmployeeList(List<EmployeeDto> employees) {
		employeeRepo.findAll().addAll(employees.stream().map(ConvertTo::employeeEntity).toList());
		log.info("employee list added " + employees);
	}

}
