package com.cg.ata.project.controller;

import java.util.List;

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

import com.cg.ata.project.model.Booking;
import com.cg.ata.project.model.Driver;
import com.cg.ata.project.model.Route;
import com.cg.ata.project.model.Vehicle;
import com.cg.ata.project.service.IBookingService;
import com.cg.ata.project.service.IDriverService;
import com.cg.ata.project.service.IRouteService;
import com.cg.ata.project.service.IVehicleService;




@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
	
	@Autowired
	private IVehicleService vehiService;
	
	@Autowired
	private IDriverService drivService;
	
	@Autowired
	private IRouteService routService;
	
	@Autowired
	private IBookingService bookService;
	
	
//==============================================================================
	@GetMapping("/view-all-booking")
	public List<Booking> getBooking() {
		List<Booking> allBookingList = (List<Booking>) bookService.viewAllBooking();
		return allBookingList;
	}
	
//===========================================================
	
	@PostMapping("/add-vehi")
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle) {
		//LOG.info(vehicle.toString());
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(vehiService.addVehicle(vehicle), status);
		return response;
	}
	
//=================================================================
	@GetMapping("/view-vehi-by-id/{vehicleID}")
	public ResponseEntity<Vehicle> viewVehicleById(@PathVariable(name = "vehicleID") int vehicleID) {
		//LOG.info(Integer.toString(vehicleID));
		Vehicle vh = vehiService.viewVehicleById(vehicleID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(vh, status);
		return response;
	}
	
//========================================================================
	@PutMapping("/modify-vehi")
	public ResponseEntity<Vehicle> modifyVehicle(@RequestBody Vehicle vehicle) {
		//LOG.info(vehicle.toString());
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(vehiService.modifyVehicle(vehicle), status);
		return response;
	}

//========================================================================
	@DeleteMapping("/delete-vehi/{vehicleId}")
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable(name = "vehicleId") int vehicleId) {
		//LOG.info(Integer.toString(vehicleId));
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(vehiService.deleteVehicle(vehicleId), status);
		return response;
	}
	
//========================================================================	
	@PostMapping("/add-Rou")
	public Route addRoute(@RequestBody Route route) {
		//LOG.info(route.toString());
		return routService.addRoute(route);
	}
	
//===========================================================================
	@GetMapping("/view-all-Rou")
	public ResponseEntity<List<Route>> getAllRouts() {
		List<Route> rouList = routService.viewAllRoutes();
		//for (Route rou : rouList)
			//LOG.info(rou.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Route>> response = new ResponseEntity<>(rouList, status);
		return response;
	}
	
	
	
//=============================================================================	
	@GetMapping("/get-Rou-by-id/{routeID}")
	public ResponseEntity<Route> viewRouteById(@PathVariable(name = "routeID") int routeID) {
		//LOG.info(Integer.toString(routeID));
		Route rou = routService.viewRouteById(routeID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Route> response = new ResponseEntity<>(rou, status);
		return response;
	}

//=============================================================================	
	@DeleteMapping("/delete-Rou/{routeId}")
	public ResponseEntity<Route> deleteRoute(@PathVariable(name = "routeId") int routeId) {
		//LOG.info(Integer.toString(routeId));
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Route> response = new ResponseEntity<>(routService.deleteRoute(routeId), status);
		return response;
	}
	
//============================================================================	
	@PutMapping("/modify-rou")
	public ResponseEntity<Route> modifyRoute(@RequestBody Route route) {
		//LOG.info(route.toString());
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<Route> response = new ResponseEntity<>(routService.modifyRoute(route), status);
		return response;
	}
	
//=============================================================================	
	@PostMapping("/add-driv")
	public Driver addDriver(@RequestBody Driver driver) {
		//LOG.info(driver.toString());
		return drivService.addDriver(driver);
	}
//=============================================================================
	@GetMapping("/view-all-vehi")
	public ResponseEntity<List<Vehicle>> viewAllVehicle() {
		List<Vehicle> vehicleList = vehiService.viewAllVehicle();
		//for (Vehicle vehiTemp : vehicleList)
			//LOG.info(vehiTemp.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Vehicle>> response = new ResponseEntity<>(vehicleList, status);
		return response;
	}
//==============================================================================	
	@GetMapping("/view-all-driv")
	public ResponseEntity<List<Driver>> viewAllDrivers() {
		List<Driver> driList = drivService.viewAllDriver();
		//for (Driver dri : driList)
			//LOG.info(dri.toString());
			HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Driver>> response = new ResponseEntity<>(driList, status);
		return response;
	}
	
//=============================================================================	
	@GetMapping("/view-driv-by-id/{driverID}")
	public ResponseEntity<Driver> viewDriverById(@PathVariable(name = "driverID") int driverID) {
		//LOG.info(Integer.toString(driverID));
		Driver dr = drivService.viewDriverById(driverID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Driver> response = new ResponseEntity<>(dr, status);
		return response;
	}
	
//=================================================================================	
	@DeleteMapping("/delete-driv/{driverId}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable(name = "driverId") int driverId) {
		//LOG.info(Integer.toString(driverId));
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Driver> response = new ResponseEntity<>(drivService.deleteDriver(driverId), status);
		return response;
	}
	
//===========================================================================	
	@PutMapping("/modify-driv")
	public ResponseEntity<Driver> modifyDriver(@RequestBody Driver driver) {
		//LOG.info(driver.toString());
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<Driver> response = new ResponseEntity<>(drivService.modifyDriver(driver), status);
		return response;
	}
}
