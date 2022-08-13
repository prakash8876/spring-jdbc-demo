package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@SpringBootApplication
public class ProductManagerApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(ProductManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<>();
		list.add(new Product("iPhone Xr", "Apple", "India", 52000.0f));
		list.add(new Product("iPhone 13", "Apple", "India", 62000.0f));
		list.add(new Product("iPhone 12", "Apple", "India", 42000.0f));
		repo.saveAll(list);
	}

}
