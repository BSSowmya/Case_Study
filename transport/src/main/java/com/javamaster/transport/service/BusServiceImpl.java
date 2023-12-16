package com.javamaster.transport.service;

import com.javamaster.transport.dao.BusRepository;
import com.javamaster.transport.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;



    public BusServiceImpl(BusRepository busRepository ) {
        this.busRepository = busRepository;
    }

    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    public Bus updateBus(long busId, Bus bus){
        Optional<Bus> busDb = this.busRepository.findById(bus.getId());
        if (busDb.isPresent()) {
            Bus busUpdate = busDb.get();
            busUpdate.setId(bus.getId());
            busUpdate.setRoute(bus.getRoute());
            busUpdate.setType(bus.getType());
            busUpdate.setRegNumber(bus.getRegNumber());
            busRepository.save(busUpdate);
            return busUpdate;
        } else {
            throw new RuntimeException("Record not found with id : " + bus.getId());
        }

    }

    public Bus getBusById(long id) {
        Optional<Bus> busDb = this.busRepository.findById(id);
        if (busDb.isPresent()) {
            return busDb.get();
        } else {
            throw new RuntimeException("Record not found with id : " + id);
        }
    }

    public List<Bus> getAllBuses() {
        return this.busRepository.findAll();
    }

    public void deleteBus(long id) {
        Optional<Bus> busDb = this.busRepository.findById(id);
        if (busDb.isPresent()) {
            this.busRepository.delete(busDb.get());
        } else {
            throw new RuntimeException("Record not found with id : " + id);
        }
    }

    public List<Object[]> getRouteWiseBusDetails(Long routeId){
        int rId = Math.toIntExact(routeId);
        return busRepository.get_route_wise_bus_details(rId);
    }
}
