package io.matoshri.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.matoshri.market.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
