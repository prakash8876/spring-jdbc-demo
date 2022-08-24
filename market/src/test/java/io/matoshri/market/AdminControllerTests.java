package io.matoshri.market;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.matoshri.market.entity.Admin;
import io.matoshri.market.entity.Customer;
import io.matoshri.market.entity.Employee;
import io.matoshri.market.entity.Product;
import io.matoshri.market.service.AdminService;

@WebMvcTest
public class AdminControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	public void testNewAdmin() throws Exception {
		Admin admin = new Admin();
		admin.setAdminName("Prakash");
		admin.setId(100);
		
		Employee emp = new Employee();
		emp.setEmployeeName("Arjun");
		emp.setCustomer(new Customer());
		
		Product[] products = new Product[] {new Product()};
		
		admin.setEmployee(emp);
		admin.setProducts(products);
		
		
	}
}
