package com.prizy.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductPrice {

	@EmbeddedId
	ProductPricePK productPriceKey = new ProductPricePK();
	Double price;
	
	public ProductPrice() {
		super();
	}
	
	public ProductPrice(ProductPricePK productPriceKey, Double price) {
		super();
		this.productPriceKey = productPriceKey;
		this.price = price;
	}
	public ProductPricePK getProductPriceKey() {
		return productPriceKey;
	}
	public void setProductPriceKey(ProductPricePK productPriceKey) {
		this.productPriceKey = productPriceKey;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductPrice [productPriceKey=" + productPriceKey + ", price=" + price + "]";
	}
	
	
}
