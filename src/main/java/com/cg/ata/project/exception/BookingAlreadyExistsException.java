package com.cg.ata.project.exception;


public class BookingAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookingAlreadyExistsException() {
		super();
	}

	public BookingAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}
}