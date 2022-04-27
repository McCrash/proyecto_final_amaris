package org.greyhawk.ejercicio.outbounds.mongo.repository;

import org.greyhawk.ejercicio.outbounds.mongo.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
