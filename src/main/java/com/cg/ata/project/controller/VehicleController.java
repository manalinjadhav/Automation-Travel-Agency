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
import com.cg.ata.project.model.Vehicle;
import com.cg.ata.project.service.VehicleServiceImpl;

@RestController
//@RequestMapping("/vehi")
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class VehicleController {

	@Autowired
	private VehicleServiceImpl vehiService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/*********view vehicle*********************/
	
	@GetMapping("/view-all-vehi")
	public ResponseEntity<List<Vehicle>> viewAllVehicle() {
		List<Vehicle> vehicleList = vehiService.viewAllVehicle();
		for (Vehicle vehiTemp : vehicleList)
			LOG.info(vehiTemp.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Vehicle>> response = new ResponseEntity<>(vehicleList, status);
		return response;
	}

	/**************************view vehicle by id***********************/
	
	@GetMapping("/view-vehi-by-id/{vehicleID}")
	public ResponseEntity<Vehicle> viewVehicleById(@PathVariable(name = "vehicleID") int vehicleID) {
		LOG.info(Integer.toString(vehicleID));
		Vehicle vh = vehiService.viewVehicleById(vehicleID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(vh, status);
		return response;
	}

	/************add vehicle****************************************/
	
//	@PostMapping("/add-vehi")
//	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
//		LOG.info(vehicle.toString());
//		HttpStatus status = HttpStatus.CREATED;
//		ResponseEntity<Vehicle> response = new ResponseEntity<>(vehiService.addVehicle(vehicle), status);
//		return response;
//	}

	/***********************modify vehicle*********************/
	
//	@PutMapping("/modify-vehi")
//	public ResponseEntity<Vehicle> modifyVehicle(@RequestBody Vehicle vehicle) {
//		LOG.info(vehicle.toString());
//		HttpStatus status = HttpStatus.CREATED;
//		ResponseEntity<Vehicle> response = new ResponseEntity<>(vehiService.modifyVehicle(vehicle), status);
//		return response;
//	}
   /**********************delete vehicle*********************/
	

}




