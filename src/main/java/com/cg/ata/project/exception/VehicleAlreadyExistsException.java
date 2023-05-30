package com.cg.ata.project.exception;


public class VehicleAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VehicleAlreadyExistsException() {
		super();
	}

	public VehicleAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}
}