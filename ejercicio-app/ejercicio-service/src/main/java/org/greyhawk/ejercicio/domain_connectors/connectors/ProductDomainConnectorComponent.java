package org.greyhawk.ejercicio.domain_connectors.connectors;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.services.ProductsService;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.domain_connectors.mappers.ProductDtoMapper;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDomainConnectorComponent implements ProductDomainConnector {

  private final ProductsService productsService;
  private final ProductDtoMapper mapper = Mappers.getMapper(ProductDtoMapper.class);

  @Override
  public ProductResponseDto insert(final ProductRequestDto productRequestDto) {
    Product insertedProduct = productsService.insert(mapper.mapRequest(productRequestDto));
    return mapper.mapResponse(insertedProduct);
  }

  @Override
  public ProductResponseDto update(final ProductRequestDto productRequestDto) {
    Product updatedProduct = productsService.update(mapper.mapRequest(productRequestDto));
    return mapper.mapResponse(updatedProduct);
  }

  @Override
  public void delete(final String id) {
    productsService.delete(id);
  }
}
