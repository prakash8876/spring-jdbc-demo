package io.matoshri.market.entity.dto;

import java.util.UUID;

import io.matoshri.market.entity.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDto {

	private final String productName;
	private final double productAmount;
	private final UUID productCode;

	public ProductDto(Product p) {
		this.productName = p.getProductName();
		this.productAmount = p.getProductAmount();
		this.productCode = p.getProductCode();
	}
}
