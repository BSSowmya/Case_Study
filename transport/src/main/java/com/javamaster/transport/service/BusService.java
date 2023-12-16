package com.javamaster.transport.service;

import com.javamaster.transport.model.Bus;

import java.util.List;

public interface BusService {

    public Bus addBus(Bus bus);

    public Bus updateBus(long busId, Bus bus);

    public Bus getBusById(long id);

    public List<Bus> getAllBuses();


    public void deleteBus(long id);

    public List<Object[]> getRouteWiseBusDetails(Long routeId);
}
