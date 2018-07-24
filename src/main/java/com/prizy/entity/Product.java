package com.prizy.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	Long barCode;
	
	String productDescription;

	public Product() {
		super();
	}
	
	
	public Product(Long barCode, String productDescription) {
		super();
		this.barCode = barCode;
		this.productDescription = productDescription;
	}

	public Long getBarCode() {
		return barCode;
	}

	public void setBarCode(Long barCode) {
		this.barCode = barCode;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	@Override
	public String toString() {
		return "Product [barCode=" + barCode + ", productDescription=" + productDescription + "]";
	}

	
	
}
