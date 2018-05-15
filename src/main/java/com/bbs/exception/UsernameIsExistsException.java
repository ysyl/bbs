package com.bbs.exception;

public class UsernameIsExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsernameIsExistsException(String msg) {
		super(msg);
	}
	
	public UsernameIsExistsException() {
		super("UsernameIsExistsException");
	}

}
