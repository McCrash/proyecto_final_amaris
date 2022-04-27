package org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request;

import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.formats.LocalDateTimeDtoFormat;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequestDto {

  public static final TypeReference<ProductRequestDto> JSON_TYPE_REF = new TypeReference<>() {
  };

  private String id;

  private String name;
  private String category;

  @Schema(example = LocalDateTimeDtoFormat.PATTERN)
  private LocalDateTime endOfSalesDate;
}
