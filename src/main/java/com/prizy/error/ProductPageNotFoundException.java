package com.prizy.error;

public class ProductPageNotFoundException extends RuntimeException {

	public ProductPageNotFoundException(String exception) {
	    super("Failed to get product details for page :" +exception);
	  }
}
