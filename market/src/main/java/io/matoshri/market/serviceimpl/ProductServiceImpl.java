package io.matoshri.market.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import io.matoshri.market.entity.dto.ProductDto;
import io.matoshri.market.repository.ProductRepository;
import io.matoshri.market.service.ProductService;
import io.matoshri.market.utils.ConvertTo;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void addNewProduct(ProductDto product) {
		productRepository.save(ConvertTo.productEntity(product));
	}

	@Override
	public void addProducts(List<ProductDto> products) {
		productRepository.saveAllAndFlush(products.stream().map(ConvertTo::productEntity).toList());
	}

}
