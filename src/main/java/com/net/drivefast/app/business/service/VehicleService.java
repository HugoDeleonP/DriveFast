package com.net.drivefast.app.business.service;

import org.springframework.stereotype.Service;

import com.net.drivefast.app.business.mapper.VehicleMapper;
import com.net.drivefast.app.persistence.repository.VehicleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VehicleService {
    
    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    
}
