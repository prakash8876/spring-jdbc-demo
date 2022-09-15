package io.matoshri.market.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "invoice_tbl")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "invoice_id", unique = true)
	private Integer id;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_type")
	private PaymentType paymentType;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "discount")
	private int discount;

	@NotNull
	@CreationTimestamp
	@Column(name = "purchase_date", updatable = false)
	private LocalDate purchaseDate;
	
	@NotNull
	@Column(name="invoice_customer_id", updatable = false)
	private Integer customerId;

//	@Column(name = "invoice_product_list")
//	private Map<Integer, BigDecimal> productList;

	
//	private File invoice;	// csv/pdf/excel/text
	
	public enum PaymentType {
		
		CASH, 
		CARD;

	}

}
