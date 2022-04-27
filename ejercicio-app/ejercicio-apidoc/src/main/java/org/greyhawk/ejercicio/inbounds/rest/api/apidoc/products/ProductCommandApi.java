package org.greyhawk.ejercicio.inbounds.rest.api.apidoc.products;

import io.swagger.v3.oas.annotations.Parameter;
import org.greyhawk.ejercicio.inbounds.rest.api.apidoc.EjercicioApiDocCommons;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.request.ProductRequestDto;
import org.greyhawk.ejercicio.inbounds.rest.api.dtos.products.response.ProductResponseDto;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.ApiDocCommons;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocCrudController;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocDelete;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.apidoc.cmd.ApiDocUpdate;
import org.greyhawk.rest.server.conventions.api.inbounds.rest.dtos.response.simple.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping(value = EjercicioApiDocCommons.PRODUCTS_MAIN_PATH, produces = ApiDocCommons.MEDIATYPE_RESPONSE)
@EjercicioApiDocCommons.ProductsCommands
public interface ProductCommandApi extends ApiDocCrudController<ProductRequestDto, ProductResponseDto> {

  @EjercicioApiDocCommons.ProductsCommands
  @Override
  ResponseEntity<SimpleResponseDto<ProductResponseDto>> insert(@Valid @RequestBody ProductRequestDto dto);

  @EjercicioApiDocCommons.ProductsCommands
  @Override
  ResponseEntity<SimpleResponseDto<ProductResponseDto>> update(
      @Parameter(description = ApiDocUpdate.PARAM_ID) @PathVariable(required = true) String id, @Valid @RequestBody ProductRequestDto dto);

  @EjercicioApiDocCommons.ProductsCommands
  @Override
  ResponseEntity<SimpleResponseDto<Void>> delete(@Parameter(description = ApiDocDelete.PARAM_ID) @PathVariable(required = true) String id);

}
