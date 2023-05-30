package com.cg.ata.project.service;

import java.util.List;

import com.cg.ata.project.model.Driver;

public interface IDriverService {
	
	public abstract List<Driver> viewAllDriver();

	public abstract Driver viewDriverById(int driverId);

	public abstract Driver modifyDriver(Driver driver);

	public abstract Driver deleteDriver(int driverId);
	
	public abstract Driver addDriver(Driver driver);
}
