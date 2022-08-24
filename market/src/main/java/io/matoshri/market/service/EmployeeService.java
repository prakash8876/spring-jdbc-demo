package io.matoshri.market.service;

import io.matoshri.market.entity.Customer;

public interface EmployeeService {
	
	void newCustomer(Customer customer);
	
	void updateCustomerMobileNo(int customerId, String mobileNo);
	
	void generateInvoice(int customerId, Customer customer);
	
}
