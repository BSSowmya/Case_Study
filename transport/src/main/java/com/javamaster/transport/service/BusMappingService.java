package com.javamaster.transport.service;

import com.javamaster.transport.dto.BusMappingDto;

import java.time.LocalDateTime;

public interface BusMappingService {
    public void mapBusToRoute(BusMappingDto busMappingDto);
}
