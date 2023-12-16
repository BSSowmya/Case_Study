package com.javamaster.transport.service;

import com.javamaster.transport.model.Route;

import java.util.List;

public interface RouteService {
    public void addRoutes(List<Route> routes);
    public void addRoute(String routeName,String pickupPoint,String dropPoint);
    public List<Route> getAllRoutes();
    public void addDataOnStartup();
}
