package com.net.drivefast.app.business.mapper;

import com.net.drivefast.app.domain.Rental;
import com.net.drivefast.app.presentation.dto.rental.RentalResponseDTO;

public class RentalMapper {

    public RentalResponseDTO toResponse(Rental rental){
        return new RentalResponseDTO(
            rental.getId(),
            rental.getDays(),
            rental.getTotalValue(),
            rental.getClient().getName(),
            rental.getVehicle().getModel()
        );
    }
}
