package com.javamaster.transport.dao;

import com.javamaster.transport.model.Bus;
import com.javamaster.transport.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByRoute(Route route);
//    @Query(nativeQuery = true, value = "CALL get_route_wise_bus_details(:p_route_id)")


    @Query(nativeQuery = true, value = "SELECT * FROM  get_route_wise_bus_details(:p_route_id)")
    List<Object[]> get_route_wise_bus_details(@Param("p_route_id") Integer routeId);
}


