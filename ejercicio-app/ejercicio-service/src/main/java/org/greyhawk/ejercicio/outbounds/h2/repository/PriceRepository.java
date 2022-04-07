package org.greyhawk.ejercicio.outbounds.h2.repository;

import org.greyhawk.ejercicio.outbounds.h2.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

  @Query("SELECT p FROM PriceEntity p WHERE p.startDate < :aplicationDate AND p.endDate > :aplicationDate "
      + "AND p.productId = :productId " + "AND p.brandId = :brandId")
  List<PriceEntity> findByApplyDateAndProductIdAndBrandId(LocalDateTime aplicationDate, Long productId, Long brandId);
}
