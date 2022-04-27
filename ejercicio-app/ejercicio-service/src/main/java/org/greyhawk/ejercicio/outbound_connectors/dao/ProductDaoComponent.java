package org.greyhawk.ejercicio.outbound_connectors.dao;

import lombok.RequiredArgsConstructor;
import org.greyhawk.ejercicio.domain.vos.Product;
import org.greyhawk.ejercicio.outbound_connectors.mappers.ProductEntityMapper;
import org.greyhawk.ejercicio.outbounds.mongo.entities.ProductEntity;
import org.greyhawk.ejercicio.outbounds.mongo.repository.ProductRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDaoComponent implements ProductDao {

    private final ProductRepository productRepository;

    public Product insert(final Product product) {
        ProductEntity savedProduct = productRepository.insert(Mappers.getMapper(ProductEntityMapper.class).mapVo(product));
        return Mappers.getMapper(ProductEntityMapper.class).mapEntity(savedProduct);
    }


    public Product update(final Product product) {
        ProductEntity savedProduct = productRepository.save(Mappers.getMapper(ProductEntityMapper.class).mapVo(product));
        return Mappers.getMapper(ProductEntityMapper.class).mapEntity(savedProduct);
    }


    public void delete(final String id) {
        this.productRepository.deleteById(id);
    }
}
