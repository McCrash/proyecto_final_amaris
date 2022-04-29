package org.greyhawk.ejercicio.domain.services;

import org.greyhawk.ejercicio.domain.vos.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

  List<Price> findByApplyDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);
  void updatePriceByproductIdAndPriceListId(Long productId, Integer priceListId, BigDecimal price);
}
