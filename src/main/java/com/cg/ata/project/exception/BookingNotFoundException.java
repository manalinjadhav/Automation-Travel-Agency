package com.cg.ata.project.exception;


public class BookingNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 106023461980066492L;

	public BookingNotFoundException() {
		super();
	}

	public BookingNotFoundException(String message) {
		super(message);
	}
}