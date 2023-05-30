package com.cg.ata.project.service;

import java.util.List;

import com.cg.ata.project.model.Vehicle;

public interface IVehicleService {
	
	public abstract List<Vehicle> viewAllVehicle();

	public abstract Vehicle viewVehicleById(int vehicleId);

	public abstract Vehicle addVehicle(Vehicle vehicle);

	public abstract Vehicle modifyVehicle(Vehicle vehicle);
	
	public abstract Vehicle deleteVehicle(int vehicleId);
}
