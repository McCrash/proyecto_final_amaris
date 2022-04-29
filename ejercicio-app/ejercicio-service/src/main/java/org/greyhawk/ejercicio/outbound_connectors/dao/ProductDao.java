package org.greyhawk.ejercicio.outbound_connectors.dao;

import org.greyhawk.ejercicio.domain.vos.Product;

import java.util.Optional;

public interface ProductDao {

  Product insert(Product product);
  Product update(Product product);
  void delete(String id);
  Optional<Product> findById(String id);
}
