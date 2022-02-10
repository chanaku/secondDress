package com.chana.exceptions.productExceptions;

public class UpdateProductException extends Exception{
	private String massage;

	public UpdateProductException(String massage) {
		super(massage);
		this.massage = massage;
	}

	public UpdateProductException() {
		super("wrror while update product");
	}
	
}
