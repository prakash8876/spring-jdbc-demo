package io.matoshri.market.service;

import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.dto.CustomerDto;

public interface EmployeeService {
	
	void newCustomer(CustomerDto customer);
	
	void updateCustomerMobileNo(int customerId, String mobileNo);
	
	void generateInvoice(int customerId, Customer customer);
	
}
