package io.matoshri.market.service;

import java.util.List;

import io.matoshri.market.entity.Product;

public interface ProductService {
	
	void addNewProduct(Product product);
	
	void addProducts(List<Product> products);
	
}
