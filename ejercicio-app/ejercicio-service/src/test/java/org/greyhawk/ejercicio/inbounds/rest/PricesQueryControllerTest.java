package org.greyhawk.ejercicio.inbounds.rest;

import org.greyhawk.conventions.tests.restapi.inbounds.rest.tests.MockMvcTest;
import org.greyhawk.ejercicio.domain.vos.Price;
import org.greyhawk.ejercicio.domain_connectors.mappers.PriceDtoMapper;
import org.greyhawk.ejercicio.domain_connectors.services.PricesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PricesQueryControllerTest extends MockMvcTest {

  private final PriceDtoMapper dtoMapper = Mappers.getMapper(PriceDtoMapper.class);
  private @Mock PricesService service;

  @Override
  protected String getUriRoot() {
    return "/prices/";
  }

  @Override
  public Object buildController() {
    return new PricesQueryController(dtoMapper, service);
  }

  Price price1 = new Price(35455L, 1L, 1, LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(30.509));
  Price price2 = new Price(35455L, 1L, 1, LocalDateTime.now(), LocalDateTime.now(), BigDecimal.valueOf(38.95));

  @Test
  @DisplayName("Find if exists and return NOT FOUND status")
  void should_not_find_unexisting() {
    // given
    Mockito.when(service.findByApplyDateAndProductIdAndBrandId(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(List.of());
    // when
    final var resp = performer().get("/find?productId=35455&brandId=1&applyDate=20201010-134456");
    // then
    buildAsserter(resp).status(HttpStatus.NOT_FOUND);
  }

  @Test
  @DisplayName("Find if exists and return OK status")
  void should_find_existing() {
    // given
    Mockito.when(service.findByApplyDateAndProductIdAndBrandId(Mockito.any(), Mockito.any(), Mockito.any()))
        .thenReturn(List.of(price1, price2));
    // when
    final var resp = performer().get("/find?productId=35455&brandId=1&applyDate=20201010-134456");
    // then
    buildAsserter(resp).status(HttpStatus.OK);
  }

}