package org.greyhawk.ejercicio.domain_connectors.mappers;

import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;
import org.greyhawk.rest.server.utils.domain_connectors.mappers.DtoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper extends DtoMapper<ProductRequestDto, Product, ProductResponseDto> {

}
