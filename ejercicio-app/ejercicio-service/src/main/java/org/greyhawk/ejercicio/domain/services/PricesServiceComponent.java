package org.greyhawk.ejercicio.domain.services;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.domain_connectors.services.PricesService;
import org.greyhawk.ejercicio.outbound_connectors.dao.PricesDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesServiceComponent implements PricesService {

  private final PricesDao pricesDao;

  @Override
  public List<Price> findByApplyDateAndProductIdAndBrandId(final LocalDateTime applyDate, final Long productId, final Long brandId) {
    return pricesDao.findByApplyDateAndProductIdAndBrandId(applyDate, productId, brandId);
  }
}