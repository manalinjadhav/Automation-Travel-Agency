package com.cg.ata.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ata.project.model.Driver;
import com.cg.ata.project.service.DriverServiceImpl;

@RestController
//@RequestMapping("/dri")
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class DriverController {

	@Autowired(required = true)
	DriverServiceImpl drivService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/***********************view all driver*********************/
	
	@GetMapping("/view-all-driv")
	public ResponseEntity<List<Driver>> viewAllDrivers() {
		List<Driver> driList = drivService.viewAllDriver();
		for (Driver dri : driList)
			LOG.info(dri.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Driver>> response = new ResponseEntity<>(driList, status);
		return response;
	}
	
    /*********************view driver by id**************************/
	
	@GetMapping("/view-driv-by-id/{driverID}")
	public ResponseEntity<Driver> viewDriverById(@PathVariable(name = "driverID") int driverID) {
		LOG.info(Integer.toString(driverID));
		Driver dr = drivService.viewDriverById(driverID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Driver> response = new ResponseEntity<>(dr, status);
		return response;
	}
	
     /********************add driver*******************************/
	
//	@PostMapping("/add-driv")
//	public Driver addDriver(@RequestBody Driver driver) {
//		LOG.info(driver.toString());
//		return drivService.addDriver(driver);
//	}
     
	/************************delete driver*********************************/
	
//	@DeleteMapping("/delete-driv/{driverId}")
//	public ResponseEntity<Driver> deleteDriver(@PathVariable(name = "driverId") int driverId) {
//		LOG.info(Integer.toString(driverId));
//		HttpStatus status = HttpStatus.OK;
//		ResponseEntity<Driver> response = new ResponseEntity<>(drivService.deleteDriver(driverId), status);
//		return response;
//	}
   
	/*********************modify driver**********************************/
//	@PutMapping("/modify-driv")
//	public ResponseEntity<Driver> modifyDriver(@RequestBody Driver driver) {
//		LOG.info(driver.toString());
//		HttpStatus status = HttpStatus.CREATED;
//		ResponseEntity<Driver> response = new ResponseEntity<>(drivService.modifyDriver(driver), status);
//		return response;
//	}

}


