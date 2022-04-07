package org.greyhawk.ejercicio.outbound_connectors.dao;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.outbound_connectors.mappers.PriceEntityMapper;
import org.greyhawk.ejercicio.outbounds.h2.repository.PriceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PricesDaoComponent implements PricesDao {

  private final PriceRepository priceRepository;

  @Override
  public List<Price> findByApplyDateAndProductIdAndBrandId(final LocalDateTime aplicationDate, final Long productId, final Long brandId) {
    return PriceEntityMapper.INSTANCE
        .mapEntityList(priceRepository.findByApplyDateAndProductIdAndBrandId(aplicationDate, productId, brandId));
  }

}
