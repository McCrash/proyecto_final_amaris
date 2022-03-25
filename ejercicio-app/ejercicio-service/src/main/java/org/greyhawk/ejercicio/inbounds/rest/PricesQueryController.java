package org.greyhawk.ejercicio.inbounds.rest;

import lombok.RequiredArgsConstructor;
import org.greyhawk.conventions.restapi.inbounds.rest.apidoc.query.ApiDocFindById;
import org.greyhawk.conventions.restapi.inbounds.rest.apidoc.query.ApiDocList;
import org.greyhawk.conventions.restapi.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.prices.PriceQueryApi;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.greyhawk.ejercicio.inbounds.rest.mappers.PriceDtoMapper;
import org.greyhawk.ejercicio.inbounds.rest.mappers.PriceDtoMapperImpl;
import org.greyhawk.ejercicio.services.PricesService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequiredArgsConstructor
public class PricesQueryController implements PriceQueryApi {

  private final PriceDtoMapper dtoMapper;
  private final PricesService service;

  @Override
  @GetMapping("find")
  public ResponseEntity<SimpleResponseDto<PriceResponseDto>> findPrices() {
    final var resp = service.find();
    if (resp.isEmpty()) {
      return SimpleResponseDto.error(ApiDocFindById.NotFound.SC);
    }

    final var mappedResp = dtoMapper.mapResponse(resp.get());
    return SimpleResponseDto.success(ApiDocFindById.Success.SC, mappedResp);
  }
}
