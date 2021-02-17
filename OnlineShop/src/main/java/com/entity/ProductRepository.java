package com.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public List<Product> findByProductname(String productname); 
	//public List<Product> findAllByProductname(String productname);
	
	@Query("select p from Product p where p.id <= 10 AND p.id > 4")
	public List<Product> findrandProducts();
}
