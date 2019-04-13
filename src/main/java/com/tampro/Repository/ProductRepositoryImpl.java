package com.tampro.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tampro.Entity.Product;


public interface ProductRepositoryImpl extends JpaRepository<Product, Integer> {
	
	 Page<Product> findAll(Pageable pageable);
	 Page<Product> findByCategoryid(int categoryid, Pageable pageable);   
	 
	  
}
