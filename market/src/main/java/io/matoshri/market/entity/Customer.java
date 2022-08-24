package io.matoshri.market.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String customerName;
	private String mobileNo;
	private String emailAddress;
	private PaymentType paymentType;
	private Product[] products;
	private Double totalAmount;
	private java.sql.Date purchaseDate;
//	private File invoice;	// csv/pdf/excel/text
//	private Photo photo; // add photo

}
