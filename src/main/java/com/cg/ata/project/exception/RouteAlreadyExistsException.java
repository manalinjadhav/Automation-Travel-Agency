package com.cg.ata.project.exception;


public class RouteAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RouteAlreadyExistsException() {
		super();
	}

	public RouteAlreadyExistsException(String exceptionMessage) {
		super(exceptionMessage);
	}
}