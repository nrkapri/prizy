package com.prizy.view;

import org.springframework.stereotype.Component;

@Component
public class ProductPriceView {
	Long barCode;
	String productDescription;
	Double averagePrice;
	Double minPrice;
	Double maxPrice;
	Double idealPrice;
	
	public ProductPriceView()
	{
		
	}
	
	
	
	public ProductPriceView(Long barCode, String productDescription, Double averagePrice, Double minPrice,
			Double maxPrice, Double idealPrice) {
		super();
		this.barCode = barCode;
		this.productDescription = productDescription;
		this.averagePrice = averagePrice;
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.idealPrice = idealPrice;
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
	public Double getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Double getIdealPrice() {
		return idealPrice;
	}
	public void setIdealPrice(Double idealPrice) {
		this.idealPrice = idealPrice;
	}



	@Override
	public String toString() {
		return "ProductPriceView [barCode=" + barCode + ", productDescription=" + productDescription + ", averagePrice="
				+ averagePrice + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", idealPrice=" + idealPrice
				+ "]";
	}
	
	
	
}
