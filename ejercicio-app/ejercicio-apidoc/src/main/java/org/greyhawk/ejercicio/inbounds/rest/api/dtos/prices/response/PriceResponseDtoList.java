package org.greyhawk.ejercicio.inbounds.rest.api.dtos.prices.response;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public class PriceResponseDtoList extends ArrayList<PriceResponseDto> {

  private static final long serialVersionUID = -4377921164178233090L;

  public static final TypeReference<PriceResponseDtoList> JSON_TYPE_REF = new TypeReference<PriceResponseDtoList>() {
  };

}
