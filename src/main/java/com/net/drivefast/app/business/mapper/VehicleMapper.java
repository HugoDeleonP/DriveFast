package com.net.drivefast.app.business.mapper;

import org.springframework.stereotype.Component;

import com.net.drivefast.app.domain.Vehicle;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleCreateDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleResponseDTO;
import com.net.drivefast.app.presentation.dto.vehicle.VehicleUpdateDTO;

@Component
public class VehicleMapper {

    public Vehicle toEntity(VehicleCreateDTO dto){
        return new Vehicle(
            dto.brand(),
            dto.model(),
            dto.licensePlate(),
            dto.diaryValue()
        );
    }

    public Vehicle toEntity(VehicleUpdateDTO dto){
        return new Vehicle(
            dto.diaryValue(),
            dto.available()
        );
    }

    public VehicleResponseDTO toResponse(Vehicle vehicle){
        return new VehicleResponseDTO(
            
        );
    }
}
