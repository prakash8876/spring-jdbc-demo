package io.matoshri.market.entity;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "customer_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	@NotNull
	@Column(name = "customer_name", unique = true)
	private String customerName;

	@NotNull
	@Column(name = "customer_mobile", unique = true)
	private String custoemrMobileNo;

	@NotNull
	@Column(name = "custoerm_email")
	@Email
	private String customerEmail;
//
//	@Column(name="customer_products_list")
//	private Map<Integer, BigDecimal> productList;
	

//	private Photo photo; // add photo

}
