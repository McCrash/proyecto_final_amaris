package org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.ToString;

import java.util.ArrayList;

@ToString
public class ProductResponseDtoList extends ArrayList<ProductResponseDto> {

  private static final long serialVersionUID = -4377921164178233090L;

  public static final TypeReference<ProductResponseDtoList> JSON_TYPE_REF = new TypeReference<ProductResponseDtoList>() {
  };

}
