package com.esprit.spring.exception;

public class BusExistsException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusExistsException(String message) {
		super(message);
	}

}

