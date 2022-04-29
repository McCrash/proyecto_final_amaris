package org.greyhawk.ejercicio.outbound_connectors.message_producers;

import org.greyhawk.ejercicio.domain.vos.Product;

import java.util.Optional;

public interface ProductsMessageProducer {

  void productInserted(Product product);
  void productUpdated(Product product);
  void productDeleted(Optional<Product> product);
}
