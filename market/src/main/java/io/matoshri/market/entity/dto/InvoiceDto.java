package io.matoshri.market.entity.dto;

import java.time.LocalDate;
import java.util.List;

import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.Invoice;
import io.matoshri.market.entity.PaymentType;
import io.matoshri.market.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InvoiceDto {

	private final PaymentType paymentType;
	private final double totalAmount;
	private final int discount;
	private final LocalDate purchaseDate;
	private final List<Customer> customer;
	private final List<Product> productList;
//	private File invoice;	// csv/pdf/excel/text

	public InvoiceDto(Invoice i) {
		this.paymentType = i.getPaymentType();
		this.totalAmount = i.getTotalAmount();
		this.discount = i.getDiscount();
		this.purchaseDate = i.getPurchaseDate();
		this.customer = i.getCustomer();
		this.productList = i.getProductList();
	}
}
