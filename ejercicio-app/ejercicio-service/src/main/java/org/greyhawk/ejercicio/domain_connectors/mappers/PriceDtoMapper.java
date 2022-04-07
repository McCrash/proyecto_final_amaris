package org.greyhawk.ejercicio.domain_connectors.mappers;

import org.greyhawk.core.rest.utils.domain_connectors.mappers.DtoResponseMapper;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper extends DtoResponseMapper<Price, PriceResponseDto> {

}
