package org.greyhawk.ejercicio.domain_connectors.connectors;

import org.greyhawk.ejercicio.domain.services.ProductsService;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.domain_connectors.mappers.ProductDtoMapper;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductDomainConnectorComponentTest {

    @Mock
    ProductsService productsService;

    @InjectMocks
    ProductDomainConnectorComponent productDomainConnector;

    ProductDtoMapper mapper = Mappers.getMapper(ProductDtoMapper.class);
    String TEST_ID = "123";
    Product TEST_RESPONSE_PRODUCT = new Product(TEST_ID, LocalDateTime.now(), LocalDateTime.now(), "test", "test", LocalDateTime.now());
    ProductRequestDto TEST_REQUEST_PRODUCT = new ProductRequestDto(TEST_ID, "test", "test", LocalDateTime.now());


    @Test
    void should_insert() {
        when(productsService.insert(any())).thenReturn(TEST_RESPONSE_PRODUCT);
        ProductResponseDto insertedProduct = productDomainConnector.insert(TEST_REQUEST_PRODUCT);
        assertEquals(mapper.mapResponse(TEST_RESPONSE_PRODUCT), insertedProduct);
    }

    @Test
    void should_update() {
        when(productsService.update(any())).thenReturn(TEST_RESPONSE_PRODUCT);
        ProductResponseDto updatedProduct = productDomainConnector.update(TEST_REQUEST_PRODUCT);
        assertEquals(mapper.mapResponse(TEST_RESPONSE_PRODUCT), updatedProduct);
    }

    @Test
    void should_delete() {
        doNothing().when(productsService).delete(any());
        productDomainConnector.delete(TEST_ID);
        verify(productsService, times(1)).delete(TEST_ID);
    }
}
