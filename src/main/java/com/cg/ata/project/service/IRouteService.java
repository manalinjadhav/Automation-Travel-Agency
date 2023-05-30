package com.cg.ata.project.service;

import java.util.List;

import com.cg.ata.project.model.Route;

public interface IRouteService {
	
	public abstract List<Route> viewAllRoutes();

	public abstract Route viewRouteById(int routeId);

	public abstract Route addRoute(Route route);

	public abstract Route modifyRoute(Route route);
	
	public abstract Route deleteRoute(int routeId);
}
