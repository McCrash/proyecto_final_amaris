package org.greyhawk.ejercicio.inbounds.rest;

import lombok.RequiredArgsConstructor;
import org.greyhawk.conventions.restapi.inbounds.rest.apidoc.query.ApiDocFindById;
import org.greyhawk.conventions.restapi.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.ejercicio.domain_connectors.mappers.PriceDtoMapper;
import org.greyhawk.ejercicio.domain_connectors.services.PricesService;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.prices.PriceQueryApi;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request.PriceRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class PricesQueryController implements PriceQueryApi {

  private final PriceDtoMapper dtoMapper;
  private final PricesService service;

  @Override
  public ResponseEntity<SimpleResponseDto<List<PriceResponseDto>>> findPrices(final PriceRequestDto priceRequestDto) {
    final var resp = service.findByApplyDateAndProductIdAndBrandId(priceRequestDto.getApplyDate(), priceRequestDto.getProductId(),
        priceRequestDto.getBrandId());
    if (resp.isEmpty()) {
      return SimpleResponseDto.error(ApiDocFindById.Response.NotFound.SC, ApiDocFindById.Response.NotFound.MSG);
    }

    final var mappedResp = dtoMapper.mapResponseList(resp);
    return SimpleResponseDto.success(ApiDocFindById.Response.Success.SC, mappedResp);
  }

}
