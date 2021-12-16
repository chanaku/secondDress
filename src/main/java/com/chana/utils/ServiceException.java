package com.chana.utils;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceException extends Exception {

	private String massage;

	public ServiceException(String massage) {
		super(massage);
		this.massage = massage;
	}
}
