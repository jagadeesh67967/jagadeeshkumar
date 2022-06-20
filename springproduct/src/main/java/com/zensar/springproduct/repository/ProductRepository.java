package com.zensar.springproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import com.zensar.springproduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductName(String productName);
	// @Query("from Product p where p.productName=?1")
	//@Query(value = "select * from product where product_name=?1" , nativeQuery = true)
	//List<Product> test(String productName);

	List<Product> findByProductNameAndProductCost(String productName, int productCost);
	// @Query("from Product p where p.productName=?1 and p.productCost=?2")
	//@Query(value = "select * from product where product_name=?1 and product_cost=?2" , nativeQuery = true)
	//List<Product> test1(String productName,int productCost);

}
