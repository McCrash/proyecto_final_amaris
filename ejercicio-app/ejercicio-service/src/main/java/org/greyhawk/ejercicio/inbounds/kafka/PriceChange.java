package org.greyhawk.ejercicio.inbounds.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceChange {

  private Long productId;
  private Integer priceListId;
  private BigDecimal price;

}
