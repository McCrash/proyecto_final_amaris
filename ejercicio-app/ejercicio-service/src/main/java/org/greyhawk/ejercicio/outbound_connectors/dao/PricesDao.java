package org.greyhawk.ejercicio.outbound_connectors.dao;

import org.greyhawk.ejercicio.domain.vos.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesDao {

  List<Price> findByApplyDateAndProductIdAndBrandId(LocalDateTime aplicationDate, Long productId, Long brandId);
  List<Price> findByProductIdAndPriceListId(Long productId, Integer priceListId);
  List<Price> updateAll(List<Price> prices);
}
