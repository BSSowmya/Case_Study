package com.javamaster.transport.controlller;

import com.javamaster.transport.dto.ResponseDto;
import com.javamaster.transport.model.Route;
import com.javamaster.transport.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class RouteController {


    @Autowired
    private RouteService routeService;




    public RouteController(RouteService routeService ) {
        this.routeService = routeService;

    }

    @PostMapping("/route")
    public ResponseEntity<?> addRoutes(  @Valid @RequestBody List<Route> routes) {
        try{
            return new ResponseEntity<>(ResponseDto.builder().message("Routes added successfully").build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/route")
    public ResponseEntity<?> getAllRoutes() {
        try{

            List<Route> routes = routeService.getAllRoutes();
            return new ResponseEntity<>(ResponseDto.builder().message("Routes fetched successfully").data(routes).build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(ResponseDto.builder().message(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
