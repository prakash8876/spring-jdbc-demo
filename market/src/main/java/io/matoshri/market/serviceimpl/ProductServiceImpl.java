package io.matoshri.market.serviceimpl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import io.matoshri.market.entity.Product;
import io.matoshri.market.entity.Products;
import io.matoshri.market.repository.ProductRepository;
import io.matoshri.market.service.ProductService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl 
					extends Products 
					implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void addNewProduct(Product product) {
		Product save = productRepository.save(product);
		log.debug("Added product : {}", save);
	}

	@Override
	public void addProducts(List<Product> products) {
		products = productRepository.saveAllAndFlush(products);
		log.debug("added product list : {}", products.size());
	}

	@Override
	public Set<Product> getAllProducts() {
		List<Product> list = this.productRepository.findAll();
		super.productSet.addAll(list);
		return super.productSet;
	}

}
