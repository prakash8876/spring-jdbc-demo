package io.matoshri.main.config;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.matoshri.main.model.Product;

public class ProductMapper implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("ID"));
		product.setItem(rs.getString("ITEM"));
		product.setPrice(rs.getInt("PRICE"));
		return product;
	}

}
