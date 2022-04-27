package org.greyhawk.ejercicio.outbounds.mongo.repository;

import org.greyhawk.ejercicio.outbounds.mongo.entities.PriceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends MongoRepository<PriceEntity, Long> {

  @Query("{'startDate': { '$lte' : ?0 }, 'endDate': { '$gt' : ?0 }, 'productId' : ?1, 'brandId' : ?2 }")
  List<PriceEntity> findByApplyDateAndProductIdAndBrandId(LocalDateTime aplicationDate, Long productId, Long brandId);
}
