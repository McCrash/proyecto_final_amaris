package org.greyhawk.ejercicio.domain.services;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.outbound_connectors.dao.PricesDao;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

  @Override
  public void updatePriceByproductIdAndPriceListId(final Long productId, final Integer priceListId, final BigDecimal price) {
    List<Price> prices = pricesDao.findByProductIdAndPriceListId(productId, priceListId);
    prices.forEach(foundPrice -> foundPrice.setPrice(price));
    pricesDao.updateAll(prices);
  }
}