package com.net.drivefast.app.presentation.dto.vehicle;

import java.math.BigDecimal;

public record VehicleUpdateDTO(
    BigDecimal diaryValue,
    Boolean available
) {

}
