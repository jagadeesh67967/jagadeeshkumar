package com.zensar.springproduct.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.zensar.springproduct.dto.ProductDto;
import com.zensar.springproduct.entity.Product;
import com.zensar.springproduct.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {
		Product product = productRepository.findById(productId).get();

		// ProductDto dto=mapToDto(product);
		return modelMapper.map(product, ProductDto.class);

		// return dto;

	}

	@Override
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize) {
		// List<Product> listOfProduct = productRepository.findAll();
		List<ProductDto> listOfProductDto = new ArrayList<ProductDto>();

		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize));
		List<Product> content = findAll.getContent();

		for (Product product : content) {
			// listOfProductDto.add(mapToDto(product));
			listOfProductDto.add(modelMapper.map(product, ProductDto.class));
		}

		return listOfProductDto;
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		// Product product = mapToEntity(productDto);
		Product product = modelMapper.map(productDto , Product.class);

		Product insertedProduct = productRepository.save(product);

		// StudentDto mapToDto=mapToDto(insertedStudent);
		return modelMapper.map(insertedProduct, ProductDto.class);

		// return mapToDto;
	}

	@Override
	public void updatedProduct(int productId, ProductDto productDto) {
		// Product product = mapToEntity(productDto);
		Product product = modelMapper.map(productDto, Product.class);

		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}
	

	/*
	 * @Override public List<ProductDto> test(String productName) { List<ProductDto>
	 * productDto = new ArrayList<>(); List<Product> products = (List<Product>)
	 * productRepository.test(productName); for(Product product:products)
	 * productDto.add(modelMapper.map(product,ProductDto.class)); return productDto; 
	 * }
	 */

	@Override
	public List<Product> findByProductNameAndProductCost(String productName, int productCost) {
		return productRepository.findByProductNameAndProductCost(productName, productCost);
	}

	
	/*
	 * @Override public List<ProductDto> test1(String productName, int productCost) {
	 * List<ProductDto> productDto = new ArrayList<>(); List<Product> products =
	 * (List<Product>) productRepository.test1(productName,productCost); for(Product
	 * product:products) productDto.add(modelMapper.map(product,productDto.class));
	 * return productDto; }
	 */
	
	/*
	 * public ProductDto mapToDto(Product product) {
	 * 
	 * ProductDto dto=new ProductDto(); dto.setProductId(product.getProductId());
	 * dto.setProductName(product.getProductName());
	 * dto.setProductCost(product.getproductCost());
	 * 
	 * return dto;
	 * 
	 * }
	 * 
	 * public Product mapToEntity(ProductDto productDto) {
	 * 
	 * Product product=new Product();
	 * product.setProductId(productDto.getProductId());
	 * product.setProductName(productDto.getProductName());
	 * product.setProductCost(productDto.getProductCost());
	 * 
	 * return product;
	 * 
	 * 
	 * }
	 */

}
