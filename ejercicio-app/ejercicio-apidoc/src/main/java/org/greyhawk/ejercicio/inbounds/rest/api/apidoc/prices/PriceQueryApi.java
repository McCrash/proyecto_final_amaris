package org.greyhawk.ejercicio.inbounds.rest.api.apidoc.prices;

import io.swagger.v3.oas.annotations.Operation;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.PricesApiDocCommons;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request.PriceRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = PricesApiDocCommons.PRICES_MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@PricesApiDocCommons.PricesQueries
public interface PriceQueryApi {

  @SuppressWarnings("checkstyle:LineLength")
  @PricesApiDocCommons.PricesQueries
  @Operation(summary = "Encuentra los precios finales y la tarifa aplicada")
  @GetMapping("find")
  ResponseEntity<SimpleResponseDto<List<PriceResponseDto>>> findPrices(@Valid PriceRequestDto priceRequestDto);

}
