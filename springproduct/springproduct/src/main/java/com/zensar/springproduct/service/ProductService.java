package com.zensar.springproduct.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.springproduct.dto.ProductDto;
import com.zensar.springproduct.entity.Product;

public interface ProductService {
	
	public ProductDto getProduct(int productId);
	
	public List<ProductDto> getAllProducts(int pageNumber,int pageSize);
	
	public ProductDto insertProduct(ProductDto product);
	
	public void updatedProduct(int productId,ProductDto productDto);
	
	public void deleteProduct(int productId);

	List<Product> findByProductName(String productName);
	//List<ProductDto> test(String productName);
	
    List<Product> findByProductNameAndProductCost(String productName,int productCost);
    //List<ProductDto> test1(String productName,int productCost);


}
