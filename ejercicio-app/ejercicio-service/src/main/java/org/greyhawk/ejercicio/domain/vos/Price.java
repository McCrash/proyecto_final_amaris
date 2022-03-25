package org.greyhawk.ejercicio.domain.vos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Price {

  private Long productId;
  private Long brandId;
  private Integer priceList;
  private LocalDateTime endDate;
  private LocalDateTime startDate;
  private BigDecimal price;

}
