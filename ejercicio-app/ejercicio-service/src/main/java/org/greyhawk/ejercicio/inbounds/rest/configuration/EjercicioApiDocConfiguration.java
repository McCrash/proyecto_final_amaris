package org.greyhawk.ejercicio.inbounds.rest.configuration;

import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.EjercicioApiDocCommons;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;

@Configuration
public class EjercicioApiDocConfiguration {

  @Bean
  public ApiInfo apiInfo() {
    return EjercicioApiDocCommons.buildApiInfo();
  }

}
