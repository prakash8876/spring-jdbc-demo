package io.matoshri.testing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.matoshri.testing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(name = "select * from user as u where u.name = :name")
	List<User> findByName(@Param("name") String name);

}
