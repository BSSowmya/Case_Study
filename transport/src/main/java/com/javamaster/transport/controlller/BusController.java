package com.javamaster.transport.controlller;

import com.javamaster.transport.CaseStudyTransportationApplication;
import com.javamaster.transport.dto.BusMappingDto;
import com.javamaster.transport.dto.ResponseDto;
import com.javamaster.transport.model.Bus;
import com.javamaster.transport.service.BusMappingService;
import com.javamaster.transport.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class BusController {
    private static final Logger logger = Logger.getLogger(CaseStudyTransportationApplication.class.getName());
    @Autowired
    private BusService busService;

    @Autowired
    private BusMappingService busMappingService;

    public BusController(BusService busService,BusMappingService busMappingService) {

        this.busService = busService;
        this.busMappingService = busMappingService;
    }

    @PostMapping("/admin/bus")
    public ResponseEntity<?> addBus( @RequestBody Bus bus){
        try{
            Bus busAdd = busService.addBus(bus);
            logger.info("Bus added successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus added successfully").data(busAdd).build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }


    }

    @PutMapping ("/admin/bus/{id}")
    public ResponseEntity<?> updateBus(@PathVariable long id, @RequestBody Bus bus){
        try{
            Bus busAdd = busService.updateBus(id,bus);
            logger.info("Bus updated successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus updated successfully").data(busAdd).build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/admin/bus/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable long id){
        try{
            busService.deleteBus(id);
            logger.info("Bus deleted successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus deleted successfully").build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity<?> getBusById( @PathVariable long id){
        try{
            Bus bus = busService.getBusById(id);
            logger.info("Bus fetched successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus fetched successfully").data(bus).build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/bus")
    public ResponseEntity<?> getBus(){
        try{
            List<Bus> buses = busService.getAllBuses();
            logger.info("Buses fetched successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus fetched successfully").data(buses).build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/busdetails")
    public ResponseEntity<?> getBusDetailsRouteWise(@Param( "routeId" ) Long routeId){
        try{
            List<Object[]> busDetails = busService.getRouteWiseBusDetails(routeId);
            List<HashMap<String,String>> result = new ArrayList<>();
            if(busDetails.isEmpty()){

                return new ResponseEntity<>(ResponseDto.builder().message("No Buses for given route fetched successfully").build(), HttpStatus.OK);
            }

          for(Object[] bus : busDetails){
              HashMap<String,String> mp = new HashMap<>();
              mp.put("bus_id",String.valueOf(bus[0]));
              mp.put("bus_reg_no",String.valueOf(bus[1]));
              mp.put("start_time",String.valueOf(bus[2]));
              mp.put("end_time",String.valueOf(bus[3]));
              result.add(mp);
          }
            logger.info("Buses fetched route wise successfully");
            return new ResponseEntity<>(ResponseDto.builder().message("Bus fetched successfully").data(result).build(), HttpStatus.OK);
        }
        catch (Exception e){
            logger.info("Exception thrown: " + e.getMessage());
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/admin/busmapping")
    public ResponseEntity<?> mapBusToRoute(@RequestBody BusMappingDto busMappingDto) {
        try {
            busMappingService.mapBusToRoute(busMappingDto);
            return new ResponseEntity<>(ResponseDto.builder().message("Bus mapped to route successfully").build(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

}
