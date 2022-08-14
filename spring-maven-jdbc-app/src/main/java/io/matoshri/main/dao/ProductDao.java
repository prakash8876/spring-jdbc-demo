package io.matoshri.main.dao;

import java.util.List;

import javax.sql.DataSource;

import io.matoshri.main.model.Product;

public interface ProductDao {
	
	void setDataSource(DataSource dataSource);
	void create(String item, Integer price);
	List<Product> fetchAll();
	Product getProductByItem(String item);
	
}
