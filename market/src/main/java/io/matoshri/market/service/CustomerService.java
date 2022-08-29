package io.matoshri.market.service;

import java.util.List;

import io.matoshri.market.entity.dto.ProductDto;

public interface CustomerService {
	
	void addProducts(Integer customerId, List<ProductDto> productList);
	void removeProductFromList(Integer customerId, Integer productId);
}
