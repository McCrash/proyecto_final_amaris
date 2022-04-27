package org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

  public static final TypeReference<ProductResponseDto> JSON_TYPE_REF = new TypeReference<ProductResponseDto>() {
  };

  private String id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String name;
  private String category;
  private LocalDateTime endOfSalesDate;
}
