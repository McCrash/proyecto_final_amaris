package org.greyhawk.ejercicio.domain.services;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.dao.ProductDao;
import org.greyhawk.ejercicio.outbound_connectors.message_producers.ProductsMessageProducer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductsServiceComponent implements ProductsService {

  private final ProductDao productDao;
  private final ProductsMessageProducer productsMessageProducer;

  @Override
  public Product insert(final Product product) {
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(LocalDateTime.now());
    Product productInserted = productDao.insert(product);
    productsMessageProducer.productInserted(product);
    return productInserted;
  }

  @Override
  public Product update(final Product product) {
    product.setUpdatedAt(LocalDateTime.now());
    Product productUpdated = productDao.update(product);
    productsMessageProducer.productUpdated(productUpdated);
    return productUpdated;
  }

  @Override
  public void delete(final String id) {
    Optional<Product> productForDelete = productDao.findById(id);
    productDao.delete(id);
    productsMessageProducer.productDeleted(productForDelete);
  }

}
