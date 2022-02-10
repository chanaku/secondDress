package com.chana.exceptions.productExceptions;

public class DeleteProductException extends Exception{
	private String massage;
	
	public DeleteProductException() {
		super("error while delete product");
	}

	public DeleteProductException(String massage) {
		super(massage);
		this.massage = massage;
	}
	
	
	
}
