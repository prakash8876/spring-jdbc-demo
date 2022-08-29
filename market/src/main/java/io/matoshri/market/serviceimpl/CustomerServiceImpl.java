package io.matoshri.market.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.dto.ProductDto;
import io.matoshri.market.repository.CustomerRepository;
import io.matoshri.market.service.CustomerService;
import io.matoshri.market.utils.ConvertTo;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void addProducts(Integer customerId, List<ProductDto> productList) {
		customerRepository.findById(customerId).ifPresent(cst -> {
			cst.setProducts(productList.stream().map(ConvertTo::productEntity).toList());
			customerRepository.save(cst);
		});
	}

	@Override
	public void removeProductFromList(Integer customerId, Integer productId) {
		Optional<Customer> cst = customerRepository.findById(customerId);
		if (cst.isPresent()) {
			Customer customer = cst.get();
			customer.getProducts().stream().forEach(p -> {
				Integer id = p.getId();
				if (id != null && id.equals(productId)) {
					customer.getProducts().remove(p);
				}
			});
			customerRepository.save(customer);
		}
	}

}
