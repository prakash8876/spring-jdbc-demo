package io.matoshri.market.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Integer id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_mobile")
	private String custoemrMobileNo;

	@Column(name = "custoerm_email")
	private String customerEmail;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "product_fk")
	private List<Product> products;

//	private Photo photo; // add photo

}
