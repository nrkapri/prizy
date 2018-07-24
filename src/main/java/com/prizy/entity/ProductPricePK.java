package com.prizy.entity;

import java.io.Serializable;

public class ProductPricePK implements Serializable {
	
	public Long barCode;
	public String store;
	
	public ProductPricePK() {
	}
	
	public ProductPricePK(Long barCode, String store) {
		super();
		this.barCode = barCode;
		this.store = store;
	}



	public Long getBarCode() {
		return barCode;
	}

	public void setBarCode(Long barCode) {
		this.barCode = barCode;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	@Override
	public String toString() {
		return "ProductPricePK [barCode=" + barCode + ", store=" + store + "]";
	}

	
	
	
}