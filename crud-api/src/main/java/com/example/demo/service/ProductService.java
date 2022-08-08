package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepository;

@Service
public class ProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		LOGGER.info("fetching list of all products");
		return repo.findAll();
	}
	
	public void save(Product product) {
		repo.save(product);
		LOGGER.info("Product {} saved", product);
	}
	
	public Product get(Long id) {
		LOGGER.info("fetching product of id {}", id);
		return repo.findById(id)
					.orElseThrow(
							() -> new ProductNotFoundException("Product id " + id + " not found."));
	}
	
	public void delete(Long id) {
		Product product = repo.findById(id)
			.orElseThrow(
					() -> new ProductNotFoundException("Product id " + id + " not found."));
		repo.delete(product);
		LOGGER.info("deleted product of id {}", id);
	}
}
