package io.matoshri.market.service;

import io.matoshri.market.entity.Product;

public interface CustomerService {
	
	void addProduct(Product product);
	void removeProduct(int productId, Product product);
}
