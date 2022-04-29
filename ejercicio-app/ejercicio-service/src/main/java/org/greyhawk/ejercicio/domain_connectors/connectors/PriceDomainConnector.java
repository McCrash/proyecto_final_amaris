package org.greyhawk.ejercicio.domain_connectors.connectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDomainConnector {
  List<PriceResponseDto> findByApplyDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);

  void updatePriceByConsumerRecordValue(String consumerRecord) throws JsonProcessingException;
}
