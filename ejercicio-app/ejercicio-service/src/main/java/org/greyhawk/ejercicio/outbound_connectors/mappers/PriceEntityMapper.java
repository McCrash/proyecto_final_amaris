package org.greyhawk.ejercicio.outbound_connectors.mappers;

import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.outbounds.h2.entities.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

  PriceEntityMapper INSTANCE = Mappers.getMapper(PriceEntityMapper.class);

  Price mapEntity(PriceEntity priceEntity);
  List<Price> mapEntityList(List<PriceEntity> priceEntity);
}