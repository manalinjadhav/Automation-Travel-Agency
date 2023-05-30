package com.cg.ata.project.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ata.project.exception.DriverNotFoundException;

import com.cg.ata.project.exception.DriverAlreadyExistsException;

import com.cg.ata.project.model.Driver;
import com.cg.ata.project.repository.DriverRepository;


@Service
public class DriverServiceImpl implements IDriverService {

	@Autowired
	DriverRepository driverRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Driver> viewAllDriver() {
		LOG.info("viewAllDriver");
		return driverRepository.findAll();
	}

	@Override
	public Driver viewDriverById(int driverId) {
		Optional<Driver> driOptional = driverRepository.findById(driverId);
		Driver dri = null;
		if (driOptional.isPresent()) {
			dri = driOptional.get();
			LOG.info(dri.toString());
			return dri;
		} else {
			String errorMessage = "Driver with driver " + driverId + " does not exist.";
			LOG.error(errorMessage);
			throw new DriverNotFoundException("Driver Not Found");
		}
	}



	@Override
	public Driver addDriver(Driver driver) {
		LOG.info(driver.toString());
		Optional<Driver> drOptional = driverRepository.findBydriverName(driver.getDriverName());
		if (drOptional.isEmpty()) {
			return driverRepository.save(driver);
		} else {
			String errorMessage = "driver with driverName" + driver.getDriverName() + " already exists.";
			LOG.error(errorMessage);
			throw new DriverAlreadyExistsException("Driver Already Exist");
		}
	}
	
	
	@Override
	public Driver modifyDriver(Driver driver) {
		LOG.info(driver.toString());
		this.viewDriverById(driver.getDriverId());
		return driverRepository.save(driver);
	}

	
	@Override
	public Driver deleteDriver(int driverId) {
		LOG.info(Integer.toString(driverId));
		Driver drivToDelete = this.viewDriverById(driverId);
		driverRepository.delete(drivToDelete);
		return drivToDelete;
	}
		
	
}
