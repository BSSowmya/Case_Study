package com.javamaster.transport.dao;

import com.javamaster.transport.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RouteRepository extends JpaRepository<Route, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO routes (route_name, pickup_point,drop_point) VALUES (:rName, :pickupPoint, :dropPoint)")
    void addRoute(@Param("rName") String rName, @Param("pickupPoint") String pickupPoint,@Param("dropPoint") String dropPoint);
}
