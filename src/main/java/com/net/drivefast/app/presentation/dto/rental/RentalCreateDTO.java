package com.net.drivefast.app.presentation.dto.rental;

public record RentalCreateDTO(
    Long clientId,
    Long vehicleId,
    Integer days
) {

}
