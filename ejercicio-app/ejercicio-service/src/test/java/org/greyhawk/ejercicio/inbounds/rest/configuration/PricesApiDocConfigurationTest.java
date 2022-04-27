package org.greyhawk.ejercicio.inbounds.rest.configuration;

import org.junit.jupiter.api.Test;
import springfox.documentation.service.ApiInfo;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PricesApiDocConfigurationTest {

  private EjercicioApiDocConfiguration ejercicioApiDocConfiguration = new EjercicioApiDocConfiguration();

  @Test
  void should_return_api_info_instance() {
    assertInstanceOf(ApiInfo.class, ejercicioApiDocConfiguration.apiInfo());
  }

  @Test
  void should_return_api_info_not_null() {
    assertNotNull(ejercicioApiDocConfiguration.apiInfo());
  }
}