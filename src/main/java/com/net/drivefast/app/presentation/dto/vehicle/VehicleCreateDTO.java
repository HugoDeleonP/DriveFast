package com.net.drivefast.app.presentation.dto.vehicle;

import java.math.BigDecimal;

public record VehicleCreateDTO(
    String brand,
    String model,
    String licensePlate,
    BigDecimal diaryValue
) {

}
