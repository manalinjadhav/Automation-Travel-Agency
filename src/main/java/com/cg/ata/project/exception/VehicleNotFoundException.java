package com.cg.ata.project.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VehicleNotFoundException extends RuntimeException {
	

	private static final long serialVersionUID = -8797621019825746776L;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	public VehicleNotFoundException() {
		super();
	}

	public VehicleNotFoundException(String message) {
		super(message);
		LOG.info(message);
	}


}