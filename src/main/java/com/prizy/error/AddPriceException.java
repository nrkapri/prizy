package com.prizy.error;

public class AddPriceException extends RuntimeException {

	private static final long serialVersionUID = 5561718139116717988L;

	public AddPriceException(String exception) {
	    super("Failed to Add new User:" +exception);
	  }
}
