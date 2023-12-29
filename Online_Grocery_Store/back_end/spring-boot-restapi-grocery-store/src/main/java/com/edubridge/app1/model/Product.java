package com.edubridge.app1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="groceries")
public class Product {
	@Id
	@GeneratedValue
	private Integer productId;
	private String productName;
	private Double productPrice;
	private String productMfDate;
	private String productExDate;
	
	public Product() {
		super();
		
	}

	public Product(Integer productId, String productName, Double productPrice, String productMfDate,
			String productExDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productMfDate = productMfDate;
		this.productExDate = productExDate;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductMfDate() {
		return productMfDate;
	}

	public void setProductMfDate(String productMfDate) {
		this.productMfDate = productMfDate;
	}

	public String getProductExDate() {
		return productExDate;
	}

	public void setProductExDate(String productExDate) {
		this.productExDate = productExDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productMfDate=" + productMfDate + ", productExDate=" + productExDate + "]";
	}
	
	

}