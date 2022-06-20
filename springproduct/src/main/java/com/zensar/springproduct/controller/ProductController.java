package com.zensar.springproduct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springproduct.dto.ProductDto;
import com.zensar.springproduct.entity.Product;
import com.zensar.springproduct.service.ProductService;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	private ProductService ProductService;

	// @RequestMapping("/product/{productId}")
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(ProductService.getProduct(productId), HttpStatus.OK);

	}

	@GetMapping("/products/productname/{productName}")
	public List<Product> findByStudentName(@PathVariable("productName") String productName) {
		return ProductService.findByProductName(productName);

	}

	/*
	 * @GetMapping("/products/productname/{productName}") public
	 * ResponseEntity<List<ProductDto>> test(@PathVariable("productName") String
	 * productName) { return new
	 * ResponseEntity<List<ProductDto>>(ProductService.test(productName),
	 * HttpStatus.FOUND); }
	 */

	@GetMapping(value = "/products/{productName}/{productCost}")
	public List<Product> findByProductNameAndProductCost(@PathVariable("productName") String productName,

			@PathVariable("productCost") int productCost) {
		return ProductService.findByProductNameAndProductCost(productName, productCost);
	}

	/*
	 * @GetMapping(value = "/products/{productName}/{productCost}") public
	 * ResponseEntity<List<ProductDto>> test1(@PathVariable("productName") String
	 * productName,
	 * 
	 * @PathVariable("productCost") int productCost) { return new
	 * ResponseEntity<List<ProductDto>>(ProductService.test1(productName,
	 * productCost), HttpStatus.FOUND); }
	 */

	// @RequestMapping(value = "/products",method = RequestMethod.GET)
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize) {
		return new ResponseEntity<List<ProductDto>>(ProductService.getAllProducts(pageNumber, pageSize),
				HttpStatus.FOUND);
	}

	// @RequestMapping(value="/students",method = RequestMethod.POST)
	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {
		return new ResponseEntity<ProductDto>(ProductService.insertProduct(productDto), HttpStatus.CREATED);

	}
	
	// @RequestMapping(value = "/products/{productId}",method = RequestMethod.PUT)
		@PutMapping(value = "/products/{productId}")
		public ResponseEntity<String> updatedProduct(@PathVariable("productId") int productId,
				@RequestBody ProductDto productDto) {

			ProductService.updatedProduct(productId, productDto);

			return new ResponseEntity<String>("Sucessfully UPDATED", HttpStatus.OK);

		}

		// @RequestMapping(value = "/products/{productId}",method =
		// RequestMethod.DELETE)
		@DeleteMapping(value = "/products/{productId}")
		public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {

			ProductService.deleteProduct(productId);

			return new ResponseEntity<String>("Sucessfully Deleted", HttpStatus.OK);

		}

}
