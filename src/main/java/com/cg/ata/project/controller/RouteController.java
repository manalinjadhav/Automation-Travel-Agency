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
import com.cg.ata.project.model.Route;
import com.cg.ata.project.service.RouteServiceImpl;

@RestController
//@RequestMapping("/Rou")
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class RouteController {

	@Autowired
	RouteServiceImpl routeService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/*******************view all route*******************/
	
	@GetMapping("/view-all-Rou")
	public ResponseEntity<List<Route>> getAllRouts() {
		List<Route> rouList = routeService.viewAllRoutes();
		for (Route rou : rouList)
			LOG.info(rou.toString());
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<List<Route>> response = new ResponseEntity<>(rouList, status);
		return response;
	}

	/******************get route by id*************************/
	
	@GetMapping("/get-Rou-by-id/{routeID}")
	public ResponseEntity<Route> viewRouteById(@PathVariable(name = "routeID") int routeID) {
		LOG.info(Integer.toString(routeID));
		Route rou = routeService.viewRouteById(routeID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Route> response = new ResponseEntity<>(rou, status);
		return response;
	}

	/*******************add route**************************/
	
//	@PostMapping("/add-Rou")
//	public Route addRoute(@RequestBody Route route) {
//		LOG.info(route.toString());
//		return routeService.addRoute(route);
//	}

	/************************delete route by Id********************/
	
//	@DeleteMapping("/delete-Rou/{routeId}")
//	public ResponseEntity<Route> deleteRoute(@PathVariable(name = "routeId") int routeId) {
//		LOG.info(Integer.toString(routeId));
//		HttpStatus status = HttpStatus.OK;
//		ResponseEntity<Route> response = new ResponseEntity<>(routeService.deleteRoute(routeId), status);
//		return response;
//	}

	/************************modify****************************/
	
//	@PutMapping("/modify-rou")
//	public ResponseEntity<Route> modifyRoute(@RequestBody Route route) {
//		LOG.info(route.toString());
//		HttpStatus status = HttpStatus.CREATED;
//		ResponseEntity<Route> response = new ResponseEntity<>(routeService.modifyRoute(route), status);
//		return response;
//	}

}























