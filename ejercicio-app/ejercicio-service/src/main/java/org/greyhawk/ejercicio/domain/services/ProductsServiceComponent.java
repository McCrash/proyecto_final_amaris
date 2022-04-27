package org.greyhawk.ejercicio.domain.services;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.dao.ProductDao;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ProductsServiceComponent implements ProductsService {

    private final ProductDao productDao;

    @Override
    public Product insert(final Product product) {
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        return productDao.insert(product);
    }

    @Override
    public Product update(final Product product) {
        product.setUpdatedAt(LocalDateTime.now());
        return productDao.update(product);
    }

    @Override
    public void delete(final String id) {
        productDao.delete(id);
    }
}
