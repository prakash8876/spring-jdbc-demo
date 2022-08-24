package io.matoshri.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.matoshri.market.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
