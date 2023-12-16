package com.javamaster.transport.service;

import com.javamaster.transport.dao.BusRepository;
import com.javamaster.transport.dao.BusScheduleRepository;
import com.javamaster.transport.dao.RouteRepository;
import com.javamaster.transport.dto.BusMappingDto;
import com.javamaster.transport.model.Bus;
import com.javamaster.transport.model.BusSchedule;
import com.javamaster.transport.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BusMappingServiceImpl implements  BusMappingService{
    @Autowired
    private BusRepository busRepository;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    public void mapBusToRoute(BusMappingDto busMappingDto) {
        Bus bus = busRepository.findById(busMappingDto.getBusId()).orElseThrow(() -> new RuntimeException("Bus not found"));
        Route route = routeRepository.findById(busMappingDto.getRouteId()).orElseThrow(() -> new RuntimeException("Route not found"));

        // Check for overlapping schedules
        if (isScheduleOverlapping(bus, busMappingDto.getStartTime(), busMappingDto.getEndTime())) {
            throw new RuntimeException("Bus schedule overlaps with existing schedule");
        }

        // Map the bus to the route
        bus.setRoute(route);

        // Create and save the bus schedule
        BusSchedule schedule = new BusSchedule();
        schedule.setStartTime(busMappingDto.getStartTime());
        schedule.setEndTime(busMappingDto.getEndTime());
        schedule.setBus(bus);
        busScheduleRepository.save(schedule);
    }

    private boolean isScheduleOverlapping(Bus bus, LocalTime newStartTime, LocalTime newEndTime) {
        List<BusSchedule> existingSchedules = bus.getBusSchedules();
        for (BusSchedule schedule : existingSchedules) {
            LocalTime startTime = schedule.getStartTime();
            LocalTime endTime = schedule.getEndTime();

            // Check for overlap
            if (newStartTime.isBefore(endTime) && newEndTime.isAfter(startTime)) {
                return true;
            }
        }
        return false;
    }

}
