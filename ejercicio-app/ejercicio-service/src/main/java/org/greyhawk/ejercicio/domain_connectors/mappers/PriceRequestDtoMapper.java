package org.greyhawk.ejercicio.domain_connectors.mappers;

import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request.PriceRequestDto;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoResponseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceRequestDtoMapper extends DtoResponseMapper<Price, PriceRequestDto> {

}
