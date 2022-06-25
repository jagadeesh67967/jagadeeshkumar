package com.zensar.springproduct.dto;

import javax.persistence.Transient;

public class ProductDto {

	private int productId;
	private String productName;
	private Double price;
	
	@Transient
	private String coupenCode;
	
	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, Double price, String coupenCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.coupenCode = coupenCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCoupenCode() {
		return coupenCode;
	}

	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", price=" + price + ", coupenCode=" + coupenCode + "]";
	}

	
}
