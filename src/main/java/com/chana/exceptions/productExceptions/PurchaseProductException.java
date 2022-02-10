package com.chana.exceptions.productExceptions;

public class PurchaseProductException extends Exception{
	private String massage;
	
	public PurchaseProductException() {
		super("error purchase product");
	}
	public PurchaseProductException(String massage) {
		super(massage);
		this.massage=massage;
	}
}
