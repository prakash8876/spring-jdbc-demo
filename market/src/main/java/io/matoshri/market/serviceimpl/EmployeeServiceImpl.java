package io.matoshri.market.serviceimpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.dto.CustomerDto;
import io.matoshri.market.repository.CustomerRepository;
import io.matoshri.market.repository.EmployeeRepository;
import io.matoshri.market.service.EmployeeService;
import io.matoshri.market.utils.ConvertTo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final CustomerRepository customerRepository;

	public EmployeeServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void newCustomer(CustomerDto customer) {
		customerRepository.save(ConvertTo.customerEntity(customer));
	}

	@Override
	public void updateCustomerMobileNo(int customerId, String mobileNo) {
		Optional<Customer> cst = customerRepository.findById(customerId);
		if (cst.isPresent()) {
			Customer customer = cst.get();
			customer.setCustoemrMobileNo(mobileNo);
			customerRepository.saveAndFlush(customer);
		}
	}

	@Override
	public void generateInvoice(int customerId, Customer customer) {
		Optional<Customer> cst = customerRepository.findById(customerId);
		if (cst.isPresent() && customer != null) {
			// generate invoice
		}
	}

}
