package io.matoshri.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.matoshri.market.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
