package io.matoshri.jpa;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.matoshri.jpa.model.Employee;
import io.matoshri.jpa.model.Mobile;
import io.matoshri.jpa.repository.EmployeeRepository;

@SpringBootApplication
public class SpringJpaOracleApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOracleApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setName("Prakash");
		employee.setDesignation("Senior Software Engineer");
		employee.setEmail("prakash@email.com");
		Mobile empMobile = new Mobile();
		empMobile.setEmployee(employee);
		Map<String, String> mobiles = new HashMap<String, String>();
		mobiles.put("primary", "9595747375");
		mobiles.put("secondary", "9999999999");
		empMobile.setMobiles(mobiles);
		employee.setMobiles(empMobile);
		repo.save(employee);
	}
}
