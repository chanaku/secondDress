package com.chana.exceptions.productExceptions;

public class ProductNameDoesntExistsException extends Exception{
	private String massage;

	public ProductNameDoesntExistsException(String massage) {
		super(massage);
		this.massage = massage;
	}

	public ProductNameDoesntExistsException() {
		super("product's name doesn't exists.");
	}
}
