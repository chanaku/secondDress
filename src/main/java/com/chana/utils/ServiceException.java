package com.chana.utils;



public class ServiceException extends Exception {

	private String massage;

	public ServiceException(String massage) {
		super(massage);
		this.massage = massage;
	}
}
