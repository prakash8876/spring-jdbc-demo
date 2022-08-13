package io.matoshri.jpa.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.matoshri.jpa.exception.EmployeeNotFoundException;
import io.matoshri.jpa.model.Employee;
import io.matoshri.jpa.repository.EmployeeRepository;
import io.matoshri.jpa.util.EmployeeConstants;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository repo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Employee> fetchAll() {
		log.info(EmployeeConstants.FETCH_EMPS);
		return repo.findAll();
	}

	@Override
	public Optional<Employee> fetchByEmpId(Integer id) throws EmployeeNotFoundException {
		log.info(EmployeeConstants.FETCH_EMP + id);
		return Optional.of(repo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found : "+ id)));
	}

	@Override
	public Optional<Employee> saveEmployee(Employee emp) {
		log.info(EmployeeConstants.SAVING + emp);
		return Optional.of(repo.save(emp));
	}

	@Override
	public Optional<Employee> updateEmployee(Integer empId, Employee emp) throws EmployeeNotFoundException {
		if (repo.existsById(empId)) {
			Optional.of(repo.saveAndFlush(emp));
			log.info(EmployeeConstants.UPDATED + empId);
			return repo.findById(empId);
		} else {
			log.error(EmployeeConstants.EMPLOYEE_NOT_FOUND + empId);
			throw new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND + empId);
		}
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Integer empId) throws EmployeeNotFoundException {
		boolean deleted = true;
		if (repo.existsById(empId)) {
			repo.deleteById(empId);
		} else { 
			deleted = false;
			throw new EmployeeNotFoundException(EmployeeConstants.EMPLOYEE_NOT_FOUND + empId);
		}
		log.info(Collections.singletonMap(EmployeeConstants.DELETED + empId, deleted));
		return Collections.singletonMap(EmployeeConstants.DELETED + empId, deleted);
	}

	
}
