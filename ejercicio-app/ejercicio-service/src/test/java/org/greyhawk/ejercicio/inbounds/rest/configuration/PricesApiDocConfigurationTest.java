package org.greyhawk.ejercicio.inbounds.rest.configuration;

import org.junit.jupiter.api.Test;
import springfox.documentation.service.ApiInfo;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PricesApiDocConfigurationTest {

  private PricesApiDocConfiguration pricesApiDocConfiguration = new PricesApiDocConfiguration();

  @Test
  void should_return_api_info_instance() {
    assertInstanceOf(ApiInfo.class, pricesApiDocConfiguration.apiInfo());
  }

  @Test
  void should_return_api_info_not_null() {
    assertNotNull(pricesApiDocConfiguration.apiInfo());
  }
}