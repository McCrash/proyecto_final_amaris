package org.greyhawk.ejercicio.inbounds.rest.api.apidoc.prices;

import org.greyhawk.conventions.restapi.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.conventions.restapi.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.PricesApiDocCommons;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = PricesApiDocCommons.PRICES_MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@PricesApiDocCommons.PricesQueries
public interface PriceQueryApi {

  @SuppressWarnings("checkstyle:LineLength")
  @PricesApiDocCommons.PricesQueries
  ResponseEntity<SimpleResponseDto<PriceResponseDto>> findPrices();

}
