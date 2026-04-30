package com.net.drivefast.app.presentation.dto.rental;

import java.math.BigDecimal;

public record RentalResponseDTO(
    Long id,
    Integer days,
    BigDecimal totalValue,
    String clientName,
    String vehicleModel
) {

}
