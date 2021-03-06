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
import org.springframework.web.client.RestTemplate;

import com.zensar.springproduct.dto.CoupenDto;
import com.zensar.springproduct.dto.ProductDto;
import com.zensar.springproduct.entity.Product;
import com.zensar.springproduct.restclient.CoupenRestClient;
import com.zensar.springproduct.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class ProductController {

	@Autowired
	private ProductService ProductService;
	private CoupenDto product;

	@Autowired
	private CoupenRestClient restClient;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */

	// @RequestMapping("/product/{productId}")
	@Operation(summary = "This is to fetch record by productId")
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(ProductService.getProduct(productId), HttpStatus.OK);

	}

	@GetMapping("/products/productname/{productName}")
	public ResponseEntity<List<ProductDto>> findByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(ProductService.findByProductName(productName), HttpStatus.FOUND);

	}

	/*
	 * @GetMapping("/products/productname/{productName}") public
	 * ResponseEntity<List<ProductDto>> test(@PathVariable("productName") String
	 * productName) { return new
	 * ResponseEntity<List<ProductDto>>(ProductService.test(productName),
	 * HttpStatus.FOUND); }
	 */

	@GetMapping(value = "/products/{productName}/{productCost}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndProductCost(
			@PathVariable("productName") String productName, @PathVariable("productCost") int productCost) {
		return new ResponseEntity<List<ProductDto>>(
				ProductService.findByProductNameAndProductCost(productName, productCost), HttpStatus.FOUND);
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
	@Operation(summary = "This is to get all the product records from database")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Fetched all records from database", content = {
					@Content(mediaType = "application/json"), @Content(mediaType = "application/xml") }) })
	@GetMapping(value = "/products")
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
			@RequestParam(value = "sortby", required = false, defaultValue = "productName") String productName,
			@RequestParam(value = "direction", required = false, defaultValue = "DESC") String product) {
		return new ResponseEntity<List<ProductDto>>(ProductService.getAllProducts(pageNumber, pageSize),
				HttpStatus.FOUND);
	}

	// @RequestMapping(value="/products",method = RequestMethod.POST)
	@Operation(summary = "to insert the record into database")
	@PostMapping(value = "/products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {

		//String CoupenCode = product.getCoupenCode();
		
		CoupenDto coupenDto = restClient.getCoupen(product.getCoupenCode());
		
		//ResponseEntity<CoupenDto> coupen = restTemplate.getForEntity("http://COUPEN-SERVICE/coupens/"+product.getCoupenCode(),CoupenDto.class);
 
		//CoupenDto couponObject = ( coupen).getBody();
		
		productDto.setPrice(productDto.getPrice()-coupenDto.getDiscount());
		
		return new ResponseEntity<ProductDto>(ProductService.insertProduct(productDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/products/{productId}",method = RequestMethod.PUT)
	@Operation(summary = "This is to update record by productId")
	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> updatedProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {

		ProductService.updatedProduct(productId, productDto);

		return new ResponseEntity<String>("Sucessfully UPDATED", HttpStatus.OK);

	}

	// @RequestMapping(value = "/products/{productId}",method =
	// RequestMethod.DELETE)
	@Operation(summary = "This is to delete record by productId from database")
	@DeleteMapping(value = "/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {

		ProductService.deleteProduct(productId);

		return new ResponseEntity<String>("Sucessfully Deleted", HttpStatus.OK);

	}

}
