package org.greyhawk.ejercicio.domain.services;

import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.dao.ProductDao;
import org.greyhawk.ejercicio.outbound_connectors.message_producers.ProductsMessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsServiceComponentTest {

    @Mock
    ProductDao productDao;

    @Mock
    ProductsMessageProducer productsMessageProducer;

    @InjectMocks
    ProductsServiceComponent productsServiceComponent;

    String TEST_ID = "123";
    Product TEST_PRODUCT = new Product(TEST_ID, LocalDateTime.now(), LocalDateTime.now(), "test", "test", LocalDateTime.now());

    @Test
    void should_insert() {
        when(productDao.insert(any())).thenReturn(TEST_PRODUCT);
        Product insertedProduct = productsServiceComponent.insert(TEST_PRODUCT);
        assertEquals(TEST_PRODUCT, insertedProduct);
    }

    @Test
    void should_update() {
        when(productDao.update(any())).thenReturn(TEST_PRODUCT);
        Product updatedProduct = productsServiceComponent.update(TEST_PRODUCT);
        assertEquals(TEST_PRODUCT, updatedProduct);
    }

    @Test
    void should_delete() {
        doNothing().when(productDao).delete(any());
        productsServiceComponent.delete(TEST_ID);
        verify(productDao, times(1)).delete(TEST_ID);
    }
}