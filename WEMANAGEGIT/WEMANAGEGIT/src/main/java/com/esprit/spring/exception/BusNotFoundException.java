package com.esprit.spring.exception;


public class BusNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusNotFoundException(String message) {
		super(message);
	}

}