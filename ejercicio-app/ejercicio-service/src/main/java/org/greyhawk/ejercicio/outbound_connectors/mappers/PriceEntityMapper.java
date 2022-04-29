package org.greyhawk.ejercicio.outbound_connectors.mappers;

import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.outbounds.mongo.entities.PriceEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {

  PriceEntity mapVo(Price price);
  Price mapEntity(PriceEntity priceEntity);
  List<Price> mapEntityList(List<PriceEntity> priceEntities);
  List<PriceEntity> mapVoList(List<Price> prices);
}