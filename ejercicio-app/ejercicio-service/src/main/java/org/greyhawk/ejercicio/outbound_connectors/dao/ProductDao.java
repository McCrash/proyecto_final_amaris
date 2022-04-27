package org.greyhawk.ejercicio.outbound_connectors.dao;

import org.greyhawk.ejercicio.domain.vos.Product;

public interface ProductDao {
    Product insert(Product product);
    Product update(Product product);
    void delete(String id);
}
