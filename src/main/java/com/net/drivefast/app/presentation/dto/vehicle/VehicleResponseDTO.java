package com.net.drivefast.app.presentation.dto.vehicle;

import java.math.BigDecimal;

public record VehicleResponseDTO(
    Long id,
    String brand,
    String model,
    String licensePlate,
    BigDecimal diaryValue,
    Boolean available
) {

}
