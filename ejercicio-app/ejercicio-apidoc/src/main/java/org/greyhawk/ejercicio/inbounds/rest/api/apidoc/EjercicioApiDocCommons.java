package org.greyhawk.ejercicio.inbounds.rest.api.apidoc;

import io.swagger.v3.oas.annotations.tags.Tag;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

public abstract class EjercicioApiDocCommons {

  public static final String PRICES_MAIN_PATH = "/prices/";
  public static final String PRODUCTS_MAIN_PATH = "/products/";

  public static ApiInfo buildApiInfo() {
    final var bldr = new ApiInfoBuilder();
    bldr.title("Prices API");
    bldr.description("REST API, offering management of prices");
    bldr.version("0.0.1");
    return bldr.build();
  }

  @Target({ METHOD, TYPE, ANNOTATION_TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @Tag(name = "Prices Commands")
  public static @interface PricesCommands {
  }

  @Target({ METHOD, TYPE, ANNOTATION_TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @Tag(name = "Prices Queries")
  public static @interface PricesQueries {
  }

  @Target({ METHOD, TYPE, ANNOTATION_TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @Tag(name = "Products Commands")
  public static @interface ProductsCommands {
  }

  @Target({ METHOD, TYPE, ANNOTATION_TYPE })
  @Retention(RetentionPolicy.RUNTIME)
  @Tag(name = "Products Queries")
  public static @interface ProductsQueries {
  }

}
