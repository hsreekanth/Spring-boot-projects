package com.ashokit.exceptions;

public class PhoneBookExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PhoneBookExceptionHandler() {
		
	}
	public PhoneBookExceptionHandler(String msg) {
		super(msg);
	}

}
