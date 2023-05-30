package com.cg.ata.project.exception;


public class DriverAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DriverAlreadyExistsException() {
		super();
	}

	public DriverAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}
}