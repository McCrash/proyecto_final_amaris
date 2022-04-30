package org.greyhawk.ejercicio.outbound_connectors.dao;

import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.mappers.ProductEntityMapper;
import org.greyhawk.ejercicio.outbounds.mongo.entities.ProductEntity;
import org.greyhawk.ejercicio.outbounds.mongo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductDaoComponentTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductDaoComponent productDao;

    ProductEntityMapper mapper = Mappers.getMapper(ProductEntityMapper.class);
    String TEST_ID = "123";
    Product TEST_PRODUCT = new Product(TEST_ID, LocalDateTime.now(), LocalDateTime.now(), "test", "test", LocalDateTime.now());

    @Test
    void should_insert() {
        when(productRepository.insert((ProductEntity) any())).thenReturn(mapper.mapVo(TEST_PRODUCT));
        Product productInserted = productDao.insert(TEST_PRODUCT);
        assertNotNull(productInserted);
        assertEquals(TEST_PRODUCT.getId(), productInserted.getId());
    }

    @Test
    void should_update() {
        when(productRepository.save(any())).thenReturn(mapper.mapVo(TEST_PRODUCT));
        Product productUpdated = productDao.update(TEST_PRODUCT);
        assertNotNull(productUpdated);
        assertEquals(TEST_PRODUCT.getId(), productUpdated.getId());
    }

    @Test
    void should_delete() {
        doNothing().when(productRepository).deleteById(any());
        productDao.delete(TEST_ID);
        verify(productRepository, times(1)).deleteById(TEST_ID);
    }

    @Test
    void should_find() {
        when(productRepository.findById(any())).thenReturn(Optional.of(mapper.mapVo(TEST_PRODUCT)));
        Optional<Product> foundProduct = productDao.findById(TEST_ID);
        assertTrue(foundProduct.isPresent());
    }

    @Test
    void should_not_find() {
        when(productRepository.findById(any())).thenReturn(Optional.ofNullable(null));
        Optional<Product> foundProduct = productDao.findById(TEST_ID);
        assertFalse(foundProduct.isPresent());
    }
}