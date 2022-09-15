package io.matoshri.market.entity;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_tbl")
public class Product {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "product_uuid_id", unique = true)
	private UUID id;

	@NotNull
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_amount")
	private BigDecimal productAmount;

	public Product(String name, BigDecimal amount) {
		this.productName = name;
		this.productAmount = amount;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", \tproductAmount=" + productAmount + "]";
	}

}
