package org.greyhawk.ejercicio.domain.services;

import org.greyhawk.ejercicio.domain.vos.Product;

public interface ProductsService {

  Product insert(Product product);
  Product update(Product product);
  void delete(String id);
}
