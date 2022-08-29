package io.matoshri.market.entity.dto;

import java.util.List;

import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDto {

	private final String customerName;
	private final String custoemrMobileNo;
	private final String customerEmail;
	private final List<Product> products;

//	private Photo photo; // add photo
	public CustomerDto(Customer customer) {
		this.customerName = customer.getCustomerName();
		this.custoemrMobileNo = customer.getCustoemrMobileNo();
		this.customerEmail = customer.getCustomerEmail();
		this.products = customer.getProducts();
	}
}
