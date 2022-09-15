package io.matoshri.market.entity;

import java.util.HashSet;
import java.util.Set;

public abstract class Products {

	protected Set<Product> productSet = new HashSet<>();
	
	abstract public Set<Product> getAllProducts();
}
