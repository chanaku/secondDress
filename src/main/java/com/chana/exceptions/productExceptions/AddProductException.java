package com.chana.exceptions.productExceptions;

public class AddProductException extends Exception{
	private String massage;
	
	public AddProductException() {
		super("error while add product");
	}
	public AddProductException(String massage) {
		super(massage);
		this.massage=massage;
	}
}
