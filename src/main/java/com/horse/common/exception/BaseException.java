package com.horse.common.exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1512807299626918941L;
	
	private String message;

	public BaseException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
