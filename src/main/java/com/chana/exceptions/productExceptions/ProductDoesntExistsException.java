package com.chana.exceptions.productExceptions;

public class ProductDoesntExistsException extends Exception{
	private String massage;

	public ProductDoesntExistsException(String massage) {
		super(massage);
		this.massage = massage;
	}

	public ProductDoesntExistsException() {
		super("product doesn't exists.");
	}
	
}
