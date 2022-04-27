package org.greyhawk.ejercicio.domain_connectors.connectors;

import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;

public interface ProductDomainConnector {
    ProductResponseDto insert(ProductRequestDto productRequestDto);
    ProductResponseDto update(ProductRequestDto productRequestDto);
    void delete(String id);
}
