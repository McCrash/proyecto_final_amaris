package org.greyhawk.ejercicio.domain_connectors.services;

import org.greyhawk.ejercicio.domain.vos.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesService {

  List<Price> findByApplyDateAndProductIdAndBrandId(LocalDateTime applyDate, Long productId, Long brandId);
}
