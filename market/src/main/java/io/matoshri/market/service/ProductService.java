package io.matoshri.market.service;

import java.util.List;

import io.matoshri.market.entity.dto.ProductDto;

public interface ProductService {
	
	void addNewProduct(ProductDto product);
	
	void addProducts(List<ProductDto> products);
	
}
