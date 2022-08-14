package io.matoshri.main.daoimpl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import io.matoshri.main.config.ProductMapper;
import io.matoshri.main.dao.ProductDao;
import io.matoshri.main.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private static final Logger log = LoggerFactory.getLogger(ProductDaoImpl.class);
	
	private static final String insertQuery = "INSERT INTO PRODUCTS(ITEM, PRICE) VALUES(?,?)";
	private static final String getAllQuery = "SELECT ID, ITEM, PRICE FROM PRODUCTS";
	private static final String getItemQuery = "SELECT * FROM PRODUCTS WHERE ITEM = ?";

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void create(String item, Integer price) {
		int update = jdbcTemplate.update(insertQuery, item, price);
		log.info("inserted:records {}", update);
		Product product = getProductByItem(item);
		log.info("Product inserted : {}", product);
		return;
	}

	public List<Product> fetchAll() {
		List<Product> products = jdbcTemplate.query(getAllQuery, new ProductMapper());
		log.info("Fetched Products: {}", products);
		return products;
	}

	public Product getProductByItem(String item) {
		Product product = jdbcTemplate.queryForObject(getItemQuery, new ProductMapper(), item);
		log.info("Fetched Product: {}", product);
		return product;
	}

}
