package org.greyhawk.ejercicio.domain_connectors.connectors;

import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDomainConnector {
  List<PriceResponseDto> findByApplyDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);
}
