package org.greyhawk.ejercicio.outbound_connectors.dao;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.mappers.ProductEntityMapper;
import org.greyhawk.ejercicio.outbounds.mongo.entities.ProductEntity;
import org.greyhawk.ejercicio.outbounds.mongo.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDaoComponent implements ProductDao {

  private final ProductRepository productRepository;

  @Override
  public Product insert(final Product product) {
    ProductEntity insertedProduct = productRepository.insert(Mappers.getMapper(ProductEntityMapper.class).mapVo(product));
    return Mappers.getMapper(ProductEntityMapper.class).mapEntity(insertedProduct);
  }

  @Override
  public Product update(final Product product) {
    ProductEntity savedProduct = productRepository.save(Mappers.getMapper(ProductEntityMapper.class).mapVo(product));
    return Mappers.getMapper(ProductEntityMapper.class).mapEntity(savedProduct);
  }

  @Override
  public void delete(final String id) {
    this.productRepository.deleteById(id);
  }

  @Override
  public Optional<Product> findById(final String id) {
    ProductEntity foundProduct = productRepository.findById(id).orElse(null);
    return Optional.ofNullable(Mappers.getMapper(ProductEntityMapper.class).mapEntity(foundProduct));
  }

}
