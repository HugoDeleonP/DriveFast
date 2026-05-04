package com.net.drivefast.app.presentation.dto.client;

import java.math.BigDecimal;

public record ClientCostDTO(
    String nameClient,
    BigDecimal costTotal
) {
    
}
