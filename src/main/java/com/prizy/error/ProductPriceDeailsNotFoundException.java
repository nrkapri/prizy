package com.prizy.error;

public class ProductPriceDeailsNotFoundException extends RuntimeException {

	public ProductPriceDeailsNotFoundException(String exception) {
	    super("Could not find product price details for productId :" +exception);
	  }
}
