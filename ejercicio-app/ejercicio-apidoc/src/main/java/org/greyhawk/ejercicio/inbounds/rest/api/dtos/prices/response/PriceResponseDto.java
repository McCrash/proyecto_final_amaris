package org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response;

import com.fasterxml.jackson.core.type.TypeReference;
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
public class PriceResponseDto {

  public static final TypeReference<PriceResponseDto> JSON_TYPE_REF = new TypeReference<PriceResponseDto>() {
  };

  private Long productId;
  private Long brandId;
  private Integer priceList;
  private LocalDateTime endDate;
  private LocalDateTime startDate;
  private BigDecimal price;

}
