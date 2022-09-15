package io.matoshri.market;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.matoshri.market.entity.Product;
import io.matoshri.market.repository.ProductRepository;

@Configuration
public class DbLoader {

	private static final String DATA_JSON = "classpath:data/data.json";

	@Bean
	public CommandLineRunner runner(ProductRepository repo) throws IOException {
		return args -> {
			InputStream inputStream = null;
			try {
				TypeReference<List<Product>> typeRef = new TypeReference<List<Product>>() {};
				File file = ResourceUtils.getFile(DATA_JSON);
				inputStream = new FileInputStream(file);
				List<Product> productList = new ObjectMapper().readValue(inputStream, typeRef);
				if (productList != null && !productList.isEmpty()) {
					repo.saveAll(productList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null)
					inputStream.close();
			}
		};
	}

}
