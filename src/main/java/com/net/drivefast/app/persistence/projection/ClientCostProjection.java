package com.net.drivefast.app.persistence.projection;

import java.math.BigDecimal;

public interface ClientCostProjection {
    String getNameClient();
    BigDecimal getCostTotal();
}
