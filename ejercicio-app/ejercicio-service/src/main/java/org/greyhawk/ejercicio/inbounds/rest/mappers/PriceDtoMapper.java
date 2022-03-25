package org.greyhawk.ejercicio.inbounds.rest.mappers;

import org.greyhawk.core.rest.utils.domain_connectors.mappers.DtoMapper;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.request.PriceRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response.PriceResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper extends DtoMapper<PriceRequestDto, Price, PriceResponseDto> {

}
