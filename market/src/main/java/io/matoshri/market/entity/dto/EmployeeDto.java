package io.matoshri.market.entity.dto;

import java.util.List;

import io.matoshri.market.entity.Employee;
import io.matoshri.market.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeDto {

	private final String employeeName;

	private final List<Invoice> invoice;

	public EmployeeDto(Employee emp) {
		this.employeeName = emp.getEmployeeName();
		this.invoice = emp.getInvoice();
	}
}
