package io.matoshri.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.matoshri.market.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
