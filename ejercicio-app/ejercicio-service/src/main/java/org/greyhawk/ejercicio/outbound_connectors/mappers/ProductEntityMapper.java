package org.greyhawk.ejercicio.outbound_connectors.mappers;

import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbounds.mongo.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {
  Product mapEntity(ProductEntity productEntity);
  ProductEntity mapVo(Product product);

}