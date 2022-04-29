package org.greyhawk.ejercicio.domain_connectors.connectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.services.PricesService;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.domain_connectors.mappers.PriceDtoMapper;
import org.greyhawk.ejercicio.inbounds.kafka.PriceChange;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceDomainConnectorComponent implements PriceDomainConnector {

  private final PricesService pricesService;
  private final PriceDtoMapper priceDtoMapper = Mappers.getMapper(PriceDtoMapper.class);
  private final ObjectMapper mapper;

  @Override
  public List<PriceResponseDto> findByApplyDateAndProductIdAndBrandId(final LocalDateTime applyDate, final Long productId,
      final Long brandId) {
    List<Price> prices = pricesService.findByApplyDateAndProductIdAndBrandId(applyDate, productId, brandId);
    return priceDtoMapper.mapResponseList(prices);
  }

  @Override
  public void updatePriceByConsumerRecordValue(final String consumerRecord) throws JsonProcessingException {
    PriceChange priceChange = mapper.readValue(consumerRecord, PriceChange.class);
    pricesService.updatePriceByproductIdAndPriceListId(priceChange.getProductId(), priceChange.getPriceListId(), priceChange.getPrice());
  }
}
