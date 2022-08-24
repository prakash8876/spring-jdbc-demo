package io.matoshri.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.exception.ResourceNotFoundException;
import io.matoshri.market.repository.AdminRepository;
import io.matoshri.market.repository.EmployeeRepository;
import io.matoshri.market.util.MarketConstants;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class AdminServiceImpl implements AdminService {
	
	private AdminRepository adminRepo;
	private EmployeeRepository empRepo;
	
	@Autowired
	public AdminServiceImpl(AdminRepository adminRepo, EmployeeRepository empRepo) {
		super();
		this.adminRepo = adminRepo;
		this.empRepo = empRepo;
	}

	@Override
	public void newAdmin(Admin admin) {
		this.adminRepo.save(admin);
		log.info("New Admin Created : {}", admin);
	}

	@Override
	public void newEmployee(Employee employee) {
		this.empRepo.save(employee);
		log.info("New Employee created : {}", employee);
	}

	@Override
	public void updateEmployee(int employeeId, Employee employee) throws ResourceNotFoundException {
		if (this.empRepo.existsById(employeeId)) {
			this.empRepo.saveAndFlush(employee);
			log.info(MarketConstants.EMPLOYEE_UPDATED + employeeId);
		} else {
			log.error(MarketConstants.EMPLOYEE_NOT_FOUNT + employeeId);
			throw new ResourceNotFoundException(MarketConstants.EMPLOYEE_NOT_FOUNT + employeeId);
		}
	}

	@Override
	public void deleteEmployee(int employeeId) throws ResourceNotFoundException {
		return;
	}

}
