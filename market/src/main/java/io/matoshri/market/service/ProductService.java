package io.matoshri.market.service;

import io.matoshri.market.entity.Product;

public interface ProductService {
	
	void addNewProduct(Product product);
	
	void addProducts(Product[] products);
	
}
