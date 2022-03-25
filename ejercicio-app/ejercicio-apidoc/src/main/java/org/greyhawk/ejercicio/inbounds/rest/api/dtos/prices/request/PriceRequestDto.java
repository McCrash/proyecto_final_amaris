package org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request;

import com.fasterxml.jackson.core.type.TypeReference;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.greyhawk.conventions.restapi.inbounds.rest.dtos.formats.LocalDateTimeDtoFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceRequestDto {

  public static final TypeReference<PriceRequestDto> JSON_TYPE_REF = new TypeReference<PriceRequestDto>() {
  };

  @NotNull
  @Schema(example = LocalDateTimeDtoFormat.EXAMPLE)
  private LocalDateTime startDate;

  @NotNull
  private Long productId;

  @NotNull
  private Long brandId;

}
