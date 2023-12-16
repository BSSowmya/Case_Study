package com.javamaster.transport.service;

import com.javamaster.transport.dao.RouteRepository;
import com.javamaster.transport.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepository routeRepository;

    private HashMap<Long,String[]> routeList;
    public RouteServiceImpl(RouteRepository routeRepository ) {
        this.routeRepository = routeRepository;
    }



    public void addRoutes(List<Route> routes) {
         routeRepository.saveAll(routes);
    }

    @Override
    public void addRoute(String routeName,String pickupPoint,String dropPoint) {
        routeRepository.addRoute(routeName,pickupPoint,dropPoint);

    }

    public void addDataOnStartup() {
        addRoute("Route-1","BANGALORE","HASSAN");
        addRoute("Route-2","BANGALORE","MADEKERI");
        addRoute("Route-3","BANGALORE","CHIKKAMAGLURU");
        addRoute("Route-4","BANGALORE","BIDAR");
        addRoute("Route-6","BANGALORE","TUMKUR");
        addRoute("Route-7","BANGALORE","CHITRADURGA");
        addRoute("Route-8","BANGALORE","DAVENGERE");
        addRoute("Route-9","BANGALORE","CHENNAI");
        addRoute("Route-10","BANGALORE","TIRICHY");
    }
    public List<Route> getAllRoutes() {
        return this.routeRepository.findAll();
    }
}
