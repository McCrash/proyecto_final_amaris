package org.greyhawk.ejercicio.inbounds.rest;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain_connectors.connectors.PriceDomainConnector;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.prices.PriceQueryApi;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request.PriceRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.query.ApiDocFindById;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class PricesQueryController implements PriceQueryApi {

  private final PriceDomainConnector priceDomainConnector;

  @Override
  public ResponseEntity<SimpleResponseDto<List<PriceResponseDto>>> findPrices(final PriceRequestDto priceRequestDto) {
    final var resp = priceDomainConnector.findByApplyDateAndProductIdAndBrandId(priceRequestDto.getApplyDate(),
        priceRequestDto.getProductId(), priceRequestDto.getBrandId());
    if (resp.isEmpty()) {
      return SimpleResponseDto.error(ApiDocFindById.Response.NotFound.SC, ApiDocFindById.Response.NotFound.MSG);
    }

    return SimpleResponseDto.success(ApiDocFindById.Response.Success.SC, resp);
  }

}
