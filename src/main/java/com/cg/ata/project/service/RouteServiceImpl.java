package com.cg.ata.project.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ata.project.exception.RouteAlreadyExistsException;
import com.cg.ata.project.exception.RouteNotFoundException;
import com.cg.ata.project.model.Route;
import com.cg.ata.project.repository.RouteRepository;

@Service
public class RouteServiceImpl implements IRouteService {

	@Autowired
	RouteRepository routeRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Route> viewAllRoutes() {
		LOG.info("viewAllRoute");
		return routeRepository.findAll();
	}

	@Override
	public Route viewRouteById(int routeId) {
		Optional<Route> rutOptional = routeRepository.findById(routeId);
		Route rou = null;
		if (rutOptional.isPresent()) {
			rou = rutOptional.get();
			LOG.info(rou.toString());
			return rou;
		} else {
			String errorMessage = "Route with route " + routeId + " does not exist.";
			LOG.error(errorMessage);
			throw new RouteNotFoundException("Route Already Exits");
		}
	}

//	public Route addRoute(Route route) {
//		Optional<Route> rOptional = routeRepository.findByDistination(route.getDistination());
//		if (rOptional != null) {
//			String exceptionMessage = "Route already exist in the database.";
//			LOG.warn(exceptionMessage);
//			throw new RouteAlreadyExistsException("Route Already Exits");
//		} else {
//			LOG.info("List returned successfully.");
//			return routeRepository.save(route);
//		}
//
//	}
	
	@Override
	public Route addRoute(Route route) {
		LOG.info(route.toString());
		Optional<Route> routOptional = routeRepository.findByDistination(route.getDistination());
		if (routOptional.isEmpty()) {
			return routeRepository.save(route);
		} else {
			String errorMessage = "Route with Distination" + route.getDistination() + " already exists.";
			LOG.error(errorMessage);
			throw new RouteAlreadyExistsException("Route Already Exist");
		}
	}
	

	@Override
	public Route modifyRoute(Route route) {
		LOG.info(route.toString());
		this.viewRouteById(route.getRouteId());
		return routeRepository.save(route);
	}

	@Override
	public Route deleteRoute(int routeId) {
		LOG.info(Integer.toString(routeId));
		Route rouToDelete = this.viewRouteById(routeId);
		routeRepository.delete(rouToDelete);
		return rouToDelete;
	}

}
