package org.greyhawk.ejercicio.inbounds.rest.configuration;

import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.PricesApiDocCommons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;

@Configuration
public class PricesApiDocConfiguration {

  @Bean
  public ApiInfo apiInfo() {
    return PricesApiDocCommons.buildApiInfo();
  }

}
