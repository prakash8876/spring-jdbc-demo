package io.matoshri.market.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="admin_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Integer id;

	@Column(name = "admin_name")
	private String adminName;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Product.class)
	@JoinColumn(name = "product_fk")
	private List<Product> products;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Employee.class)
	@JoinColumn(name = "employee_fk")
	private List<Employee> employees;
}
