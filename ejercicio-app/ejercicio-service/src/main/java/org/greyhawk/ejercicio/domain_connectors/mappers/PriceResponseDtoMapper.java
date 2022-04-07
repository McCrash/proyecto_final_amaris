package org.greyhawk.ejercicio.domain_connectors.mappers;

import org.greyhawk.conventions.restapi.domain_connectors.mappers.PagedResponseMapper;
import org.greyhawk.core.rest.utils.domain_connectors.mappers.PagingResponseMapper;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.springframework.stereotype.Component;

@Component
public class PriceResponseDtoMapper extends PagedResponseMapper<PriceResponseDto> {

  public PriceResponseDtoMapper(final PagingResponseMapper pagingMapper) {
    super(pagingMapper);
  }

}
